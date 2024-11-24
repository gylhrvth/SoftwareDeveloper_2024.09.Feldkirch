package Aylin.week10.Influencer;

public abstract class Channel {
    private String platformName;
    private int followers;
    private float engagementRate;

    public Channel(String platformName, int followers, float engagementRate){
        this.platformName = platformName;
        this.followers = followers;
        this.engagementRate = engagementRate;
    }

    public String getPlatformName() {
        return platformName;
    }

    public int getFollowers() {
        return followers;
    }

    public float getEngagementRate() {
        return engagementRate;
    }

    public abstract String showChannelInfo();

}
