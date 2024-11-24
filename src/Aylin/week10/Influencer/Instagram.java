package Aylin.week10.Influencer;

public class Instagram extends Channel{

    private int posts;
    private int reelsViews;

    public Instagram(String platformName, int followers, float engagementRate, int posts, int reelsViews){
        super (platformName, followers, engagementRate);
        this.posts = posts;
        this.reelsViews = reelsViews;
    }

    @Override
    public String showChannelInfo() {
        return "── Followers: " + super.getFollowers() + " Million\n" +
                "── Engagement Rate: " + super.getEngagementRate() + "%\n" +
                "── Posts: " + posts + " Million\n" +
                "── Reels views: " + reelsViews + " Million";
    }
}
