package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialNetwork socialNetwork = null;

        try {
            File file = new File("social_network.csv");
            Scanner fileScanner = new Scanner(file);
            socialNetwork = new SocialNetwork(fileScanner);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        System.out.println("Total users: " + socialNetwork.getNumVertices());
        System.out.println("Total friendships: " + socialNetwork.getNumEdges());

        while (true) {
            System.out.println("Enter a name to recommend for, or -1 to exit:");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }

            List<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(input);
            if (recommendations.isEmpty()) {
                System.out.println("User not found or no recommendations available.");
            } else {

                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top 10 recommendations based on friendship strength:");
                recommendations.stream().limit(10).forEach(r ->
                        System.out.println(r.getUser() + " with recommendation strength: " + r.getRecommendationStrength()));
            }
        }
        scanner.close();
    }
}
