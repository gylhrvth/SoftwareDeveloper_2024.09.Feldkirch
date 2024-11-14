package Aylin.week08.Zoo;

import Gyula.WildColors;
import java.util.Random;
import java.util.Vector;

public class Zookeeper {
    public static Random random = new Random();

    private String name;
    private String favSpepcies;
    private Vector<Enclosure> taskList;

    public Zookeeper(String name, String favSpepcies) {
        this.name = name;
        this.favSpepcies = favSpepcies;
        this.taskList = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public String getFavSpecies() {
        return favSpepcies;
    }

    public void addTask(Enclosure task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    // Performs the daily task of feeding animals in assigned enclosures
    public void performDailyTask() {
        System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + name + WildColors.resetColor() + "'s shift begins.");
        for (Enclosure enc : taskList) {
            enc.dailyTasks(this);
        }
    }
}
