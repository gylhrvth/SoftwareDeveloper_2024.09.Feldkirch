package Erik.week10.Influencer;

import java.util.Vector;

public class Influencer {

    // Attribute
    private String name;
    private int age;
    private String category;
    private Vector<Channel> channels;
    private Vector<Friend> friends;


    // Konstruktor
    public Influencer(String name, int age, String category) {
        this.name = name;
        this.age = age;
        this.category = category;
        this.channels = new Vector<>();
        this.friends = new Vector<>();
    }


    // Getter - Setter


    // Methoden
    @Override
    public String toString() {
        return "Influencer: >> " + name
                + " / Alter: >> " + age
                + " Jahre / Kategorie: >> " + category
                + " / Channels: >> " + channels
                + " / Freunde: >> " + friends;
    }

    public void addChannel(Channel channel) {
        if (!channels.contains(channel)) {
            channels.add(channel);
        }
    }

    public void printAllChannels() {
        for (Channel channel : channels) {
            channel.showChannelInfo();
        }
    }

    // die, die Anzahl der Follower über alle Channels hinweg summiert
    public void getTotalFollowers(){

    }

    // die den Channel mit den meisten Followern zurückgibt.
    public void findMostPopularChannel(){

    }

    // die alle Channels nach der Anzahl ihrer Follower sortiert auflistet.
    public void printChannelsSortedByFollowers(){

    }
}