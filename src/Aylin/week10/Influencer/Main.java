package Aylin.week10.Influencer;

public class Main {
    public static void main(String[] args) {
        Channel youtubeMrBeast = new YouTube("YouTube", 263, 10, 214, 742);
        Channel instaMrBeast = new Instagram("Instagram", 61, 4, 3, 70);
        Channel tikTokMrBeast = new TikTok("TikTok", 105, 2, 370, 30);
        Channel youtubeRae = new YouTube("Youtube", 4,5, 5, 30);
        Channel instaRae = new Instagram("Instagram", 39, 7, 1200, 21);
        Channel tikTokRae = new TikTok("TikTok", 88, 5, 623, 18);
        Channel youtubeNinja = new YouTube("YouTube", 24, 4, 24, 3000);

        Influencer mrBeast = new Influencer("Mr. Beast", 26, "Entertainment");
        Influencer rae = new Influencer("Addison Rae", 24, "Dance");
        Influencer ninja = new Influencer("Ninja", 32, "Gaming");

        mrBeast.addChannel(youtubeMrBeast);
        mrBeast.addChannel(instaMrBeast);
        mrBeast.addChannel(tikTokMrBeast);
        rae.addChannel(youtubeRae);
        ninja.addChannel(youtubeNinja);

        mrBeast.printChannels();
        rae.printChannels();

        mrBeast.printTotalFollowers();
        rae.printTotalFollowers();

        mrBeast.printMostPopularChannel();
        rae.printMostPopularChannel();

        mrBeast.addFriends(rae);
        mrBeast.addFriends(ninja);
        rae.addFriends(ninja);
        mrBeast.printFriend();
        rae.printFriend();
    }
}
