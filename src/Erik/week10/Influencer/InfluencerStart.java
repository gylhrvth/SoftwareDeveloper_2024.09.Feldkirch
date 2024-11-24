package Erik.week10.Influencer;

public class InfluencerStart {
    public static void main(String[] args) {

        // Objekt erstellen
        Influencer influencer = new Influencer("Rezo", 32, "Musik, Unterhaltung");

        YoutubeChannel ytChannel1 = new YoutubeChannel("Youtube", "rezoJaLolEy", 1640000, 2.6f, 1640000, 168);
        YoutubeChannel ytChannel2 = new YoutubeChannel("Youtube", "Renzo", 1200000, 3.6f, 1200000, 420);
        YoutubeChannel ytChannel3 = new YoutubeChannel("Youtube", "Schlumpf", 550000, 3.2f, 550000, 349);
        InstagramChannel instaChannel = new InstagramChannel("Instagram", "Rezo", 1400000, 2.6f, 169, 35000);
        TikTokChannel ttChannel = new TikTokChannel("TikTok", "Rezo", 1800000, 5f, 100, 500000);


        // Methoden aufrufen
        // Channel in liste adden
        influencer.addChannel(ytChannel1);
        influencer.addChannel(ytChannel2);
        influencer.addChannel(ytChannel3);
        influencer.addChannel(instaChannel);
        influencer.addChannel(ttChannel);


        System.out.println("-".repeat(40));
        System.out.println("Gesamt Follower aller Channel: >> " + influencer.getTotalFollowers());
        System.out.println("-".repeat(40));
        System.out.println("Der berümteste Channel ist: >> " + influencer.findMostPopularChannel().getPlattformName());
        System.out.println("-".repeat(40));
        System.out.println("Alle Channel nach beliebtheit aufgelistet:");
        influencer.printChannelsSortedByFollowers();
        System.out.println("-".repeat(40));
    }
}