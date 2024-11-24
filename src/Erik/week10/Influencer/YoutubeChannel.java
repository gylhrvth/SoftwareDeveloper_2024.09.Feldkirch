package Erik.week10.Influencer;

public class YoutubeChannel extends Channel {

    // Attribute
    private int subscribers;
    private int videosUploaded;


    // Konstruktor
    public YoutubeChannel(String plattformName, String channelName, int follower, float eiferInProzent, int subscribers, int videosUploaded) {
        super(plattformName, channelName, follower, eiferInProzent);
        this.subscribers = subscribers;
        this.videosUploaded = videosUploaded;
    }


    // Methoden
    @Override
    public void showChannelInfo() {
        System.out.printf("Plattform Name: >> %s / Channel Name: >> %-12s / Subscribers: >> %7d / Uploaded Videos: >> %d\n",getPlattformName(),getChannelName(),subscribers,videosUploaded);
    }


}