package Erik.week10.Influencer;

public class InstagramChannel extends Channel {

    // Attribute
    private int posts;
    private int reelsViews;


    // Konstruktor
    public InstagramChannel(String plattformName, String channelName, int follower, float eiferInProzent, int posts, int reelsViews) {
        super(plattformName, channelName, follower, eiferInProzent);
        this.posts = posts;
        this.reelsViews = reelsViews;
    }


    // Getter - Setter


    // Methoden
    @Override
    public void showChannelInfo() {
        System.out.println("Beiträge: >> " + posts
                + "Reels Aufrufe: >> " + reelsViews);
    }


}