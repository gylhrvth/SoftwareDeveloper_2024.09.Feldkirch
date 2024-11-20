package Erik.week10.Influencer;

public abstract class Channel {     // Abstrakte Klasse und meine Superklasse

    // Attribute
    private String plattformName;
    private int follower;
    private float eiferInProzent;


    // Konstruktor
    public Channel(String plattformName, int follower, float eiferInProzent){
        this.plattformName = plattformName;
        this.follower = follower;
        this.eiferInProzent = eiferInProzent;
    }


    // Methoden
    public abstract String showChannelInfo();     // Methode falsch als abstract gemacht ohne void geschrieben.
}