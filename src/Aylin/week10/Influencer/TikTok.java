package Aylin.week10.Influencer;

public class TikTok extends Channel{

    private int videosUploaded;
    private int averageViews;

    public TikTok(String platformName, int followers, float engagementRate, int videosUploaded, int averageViews){
        super (platformName, followers, engagementRate);
        this.videosUploaded = videosUploaded;
        this.averageViews = averageViews;
    }

    @Override
    public String showChannelInfo() {
        return "── Followers: " + super.getFollowers() + " Million\n" +
                "── Engagement Rate: " + super.getEngagementRate() + "%\n" +
                "── Uploaded videos: " + videosUploaded + "\n" +
                "── Average views: " + averageViews + " Million";
    }
}
