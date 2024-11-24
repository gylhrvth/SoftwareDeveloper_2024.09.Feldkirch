package Erik.week10.Influencer;

import java.util.Vector;

public class Influencer {

    // Attribute
    private String name;
    private int age;
    private String category;
    private Vector<Channel> channelList;
    private Vector<Friend> friendList;


    // Konstruktor
    public Influencer(String name, int age, String category) {
        this.name = name;
        this.age = age;
        this.category = category;
        this.channelList = new Vector<>();
        this.friendList = new Vector<>();
    }


    // Methoden
    @Override
    public String toString() {
        return "Influencer: >> " + name
                + " / Alter: >> " + age
                + " Jahre / Kategorie: >> " + category
                + " / Channels: >> " + channelList
                + " / Freunde: >> " + friendList;
    }

    public void addChannel(Channel channel) {
        if (!channelList.contains(channel)) {
            channelList.add(channel);
        }
    }

    public void printAllChannels() {
        for (Channel channel : channelList) {
            channel.showChannelInfo();
        }
    }

    // die, die Anzahl der Follower über alle Channels hinweg summiert
    public int getTotalFollowers() {
        int totalFollowers = 0;
        for (Channel ch : channelList) {
            totalFollowers += ch.getFollower();
        }
        return totalFollowers;
    }

    // die den Channel mit den meisten Followern zurückgibt.
    public Channel findMostPopularChannel() {
        Channel mostPopular = null;
        for (Channel ch : channelList) {
            if (mostPopular == null || ch.getFollower() > mostPopular.getFollower()) {
                mostPopular = ch;
            }
        }
        return mostPopular;
    }

    // die alle Channels nach der Anzahl ihrer Follower sortiert auflistet.
    public void printChannelsSortedByFollowers() {
        for (int i = 0; i < channelList.size() - 1; i++) {
            for (int j = 0; j < channelList.size() - 1 - i; j++) {
                if (channelList.get(j).getFollower() < channelList.get(j + 1).getFollower()) {
                    Channel temp = channelList.get(j + 1);
                    channelList.set(j + 1, channelList.get(j));
                    channelList.set(j + 1, temp);
                }
            }
        }
        printAllChannels();
    }
}