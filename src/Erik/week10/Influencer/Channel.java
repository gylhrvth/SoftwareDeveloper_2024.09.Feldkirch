package Erik.week10.Influencer;

public abstract class Channel {     // Abstrakte Klasse und meine Superklasse

    // Attribute
    private String plattformName;
    private String channelName;
    private int follower;
    private float eiferInProzent;


    // Konstruktor
    public Channel(String plattformName, String channelName, int follower, float eiferInProzent) {
        this.plattformName = plattformName;
        this.channelName = channelName;
        this.follower = follower;
        this.eiferInProzent = eiferInProzent;
    }


    // Getter - Setter
    public int getFollower() {
        return follower;
    }

    public String getPlattformName() {
        return plattformName;
    }

    public String getChannelName() {
        return channelName;
    }


    // Methoden
    public abstract void showChannelInfo();     // Methode falsch als abstract gemacht ohne void geschrieben.
}