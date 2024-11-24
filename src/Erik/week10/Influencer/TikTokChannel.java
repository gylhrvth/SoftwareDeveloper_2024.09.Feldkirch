package Erik.week10.Influencer;

public class TikTokChannel extends Channel {

    // Attribute
    private int videosUploaded;
    private int averageViews;


    // Konstruktor
    public TikTokChannel(String plattformName, String channelName, int follower, float eiferInProzent, int videosUploaded, int averageViews) {
        super(plattformName, channelName, follower, eiferInProzent);
        this.videosUploaded = videosUploaded;
        this.averageViews = averageViews;
    }


    // Getter - Setter


    // Methoden
    @Override
    public void showChannelInfo() {
        System.out.println("Durchschnittliche Aufrufe: >> " + averageViews + " Hochgeladene Videos: >> " + videosUploaded);
    }
}