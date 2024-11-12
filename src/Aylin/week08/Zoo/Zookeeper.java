package Aylin.week08.Zoo;

import java.util.Vector;

public class Zookeeper {
    private String name;
    private String tasks;
    private Vector<Enclosure> enclosureList;

    public Zookeeper(String name, String tasks){
        this.name = name;
        this.tasks = tasks;
        this.enclosureList = new Vector<>();
    }

    public void assignEnclosureAndFeed(Enclosure enclosure) {
        this.enclosureList.add(enclosure);

        for (Enclosure enc : enclosureList){
            enc.getName();
        }
    }
}
