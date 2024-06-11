package homework4;

import java.util.*;

public class SocialNetwork {
    private Map<String, List<Friendship>> adjacencyList;
    private int numVertices;
    private int numEdges;

    public SocialNetwork() {
        adjacencyList = new HashMap<>();
        numVertices = 0;
        numEdges = 0;
    }

    public SocialNetwork(Scanner in) {
        this();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String friend1 = parts[0];
                String friend2 = parts[1];
                int strength = Integer.parseInt(parts[2]);
                addFriendship(new Friendship(friend1, friend2, strength));
            }
        }
    }

    public void addUser(String user) {
        if (!adjacencyList.containsKey(user)) {
            adjacencyList.put(user, new ArrayList<>());
            numVertices++;
        }
    }

    public void addFriendship(Friendship f) {
        String friend1 = f.getFriend1();
        String friend2 = f.getFriend2();
        int strength = f.getFriendshipStrength();

        addUser(friend1);
        addUser(friend2);

        adjacencyList.get(friend1).add(new Friendship(friend1, friend2, strength));
        adjacencyList.get(friend2).add(new Friendship(friend2, friend1, strength));
        numEdges++;
    }

    public List<FriendshipRecommendation> recommendFriends(String user) {
        Map<String, Integer> potentialFriends = new HashMap<>();

        if (!adjacencyList.containsKey(user)) {
            return new ArrayList<>();
        }

        List<Friendship> friends = adjacencyList.get(user);

        for (Friendship friendship : friends) {
            String friend = friendship.getFriend2();
            int userToFriendStrength = friendship.getFriendshipStrength();

            for (Friendship friendsFriendship : adjacencyList.get(friend)) {
                String friendsFriend = friendsFriendship.getFriend2();
                int friendToFriendStrength = friendsFriendship.getFriendshipStrength();

                if (!friendsFriend.equals(user) && !adjacencyList.get(user).contains(friendsFriendship)) {
                    int recommendationStrength = Math.min(userToFriendStrength, friendToFriendStrength);
                    potentialFriends.put(friendsFriend, potentialFriends.getOrDefault(friendsFriend, 0) + recommendationStrength);
                }
            }
        }

        List<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        Collections.sort(recommendations);
        return recommendations;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }
}
