package Erik.week10.Influencer;

public class InstagramChannel extends Channel {

    // Attribute
    private int posts;
    private int reelsViews;


    // Konstruktor
    public InstagramChannel(int posts, int reelsViews, String plattformName, int follower, float eiferInProzent) {
        super(plattformName, follower, eiferInProzent);
        this.posts = posts;
        this.reelsViews = reelsViews;
    }


    // Getter - Setter


    // Methoden
    @Override
    public String showChannelInfo() {
        return "Beiträge: >> " + posts
                + "Reels Aufrufe: >> " + reelsViews;
    }


}