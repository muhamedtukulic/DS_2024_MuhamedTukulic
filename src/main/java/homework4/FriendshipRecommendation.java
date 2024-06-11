package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private int recommendationStrength;

    public FriendshipRecommendation(String user, int recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    public String getUser() {
        return user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation other) {
        return Integer.compare(other.recommendationStrength, this.recommendationStrength);
    }
}
