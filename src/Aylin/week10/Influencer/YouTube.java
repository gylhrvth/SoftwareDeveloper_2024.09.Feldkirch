package Aylin.week10.Influencer;

public class YouTube extends Channel{
    private int subscribers;
    private int videosUploaded;

    public YouTube(String platformName, int followers, float engagementRate, int subscribers, int videosUploaded){
        super (platformName, followers, engagementRate);
        this.subscribers = subscribers;
        this.videosUploaded = videosUploaded;
    }

    @Override
    public String showChannelInfo() {
        return "── Followers: " + super.getFollowers() + " Million\n" +
                "── Engagement Rate: " + super.getEngagementRate() + "%\n"+
                "── Subscribers: " + subscribers + "\n" +
                "── Uploaded Videos: " + videosUploaded;
    }
}
