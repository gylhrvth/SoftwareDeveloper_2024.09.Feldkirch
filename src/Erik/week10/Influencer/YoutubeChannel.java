package Erik.week10.Influencer;

public class YoutubeChannel extends Channel {

    // Attribute
    private int subscribers;
    private int videosUploaded;


    // Konstruktor
    public YoutubeChannel(int subscribers, int videosUploaded, String plattformName, int follower, float eiferInProzent) {
        super(plattformName, follower, eiferInProzent);
        this.subscribers = subscribers;
        this.videosUploaded = videosUploaded;
    }


    // Getter - Setter


    // Methoden
    @Override
    public String showChannelInfo() {
        return "Abonnenten: >> " + subscribers
                + "Hochgeladene Videos: >> " + videosUploaded;
    }


}