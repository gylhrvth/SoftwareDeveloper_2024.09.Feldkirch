package Erik.week10.Influencer;

public class TikTokChannel extends Channel {

    // Attribute
    private int videosUploaded;
    private int averageViews;


    // Konstruktor
    public TikTokChannel(int videosUploaded, int averageViews, String plattformName, int follower, float eiferInProzent) {
        super(plattformName, follower, eiferInProzent);
        this.videosUploaded = videosUploaded;
        this.averageViews = averageViews;
    }


    // Getter - Setter


    // Methoden
    @Override
    public String showChannelInfo() {
        return "Durchschnittliche Aufrufe: >> " + averageViews
                + "Hochgeladene Videos: >> " + videosUploaded;
    }


}