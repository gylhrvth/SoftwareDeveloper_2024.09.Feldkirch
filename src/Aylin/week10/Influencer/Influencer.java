package Aylin.week10.Influencer;

import java.util.Vector;

public class Influencer{
    private String name;
    private int age;
    private String category;
    private Vector<Channel> channels;
    private Vector<Influencer> friends;

    public Influencer(String name, int age, String category){
        this.name = name;
        this.age = age;
        this.category = category;
        this.channels = new Vector<>();
        this.friends = new Vector<>();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nCategory: " + category + "." ;
    }

    public void addChannel(Channel channel){
        channels.add(channel);
    }

    public void printChannels(){
        if(channels.isEmpty()){
            System.out.println(name + " has no active channels.\n");
        }else{
            System.out.println(name + " channels: ");
            for (Channel channel : channels){
                System.out.println("─ " + channel.getPlatformName());
                System.out.println(channel.showChannelInfo());
            }
            System.out.println();
        }
    }

    public int getTotalFollowers(){
        int totalFollowers = 0;
        for(Channel channel : channels){
            totalFollowers += channel.getFollowers(); ;
        }
        return totalFollowers;
    }

    public void printTotalFollowers(){
        if(getTotalFollowers() == 0){
            System.out.println(name + " has no followers.\n");
        }else{
            System.out.println(name + " has " + getTotalFollowers() + " followers.\n");
        }
    }

    public Channel findMostPopularChannel(){
        Channel mostPopularChannel = null;
        int maxFollower = 0;
        for (Channel channel : channels) {
            if (channel.getFollowers() > maxFollower) {
                maxFollower = channel.getFollowers();
                mostPopularChannel = channel;
            }
        }
        return mostPopularChannel;
    }

    public void printMostPopularChannel(){
        if(findMostPopularChannel() == null){
            System.out.println(name + " has no Channel.\n");
        }else{
            System.out.println(findMostPopularChannel().getPlatformName() + " is the most popular Channel of " + name + " with " + findMostPopularChannel().getFollowers() + " followers.\n");
        }
    }

    public void addFriends(Influencer friend){
        if(!friends.contains(friend)){
            friends.add(friend);
            friend.addFriends(this);
        }
    }

    public void printFriend(){
        if(friends.isEmpty()) {
            System.out.println(name + " has no friends.");
        }else{
            for (Influencer friend : friends){
                System.out.println(name + "'s friends:\n" +
                        "* " + friend.name);

            }
        }
    }


    public String getName() {
        return name;
    }

    public Vector<Channel> sortByFollowers(){
        Vector<Channel> sortedChannels = new Vector<>();
        for (Channel channel : channels){
            sortedChannels.add(channel);
        }
        for (int i = 0; i < sortedChannels.size(); i++) {
            for (int j = 0; j < sortedChannels.size() - 1 -i; j++) {
                if (sortedChannels.get(j).getFollowers() < sortedChannels.get(j+1).getFollowers()){
                    Channel temp = sortedChannels.get(j);
                    sortedChannels.set(j, sortedChannels.get(j+1));
                    sortedChannels.set(j+1, temp);
                }
            }
        }
        return sortedChannels;
    }
}
