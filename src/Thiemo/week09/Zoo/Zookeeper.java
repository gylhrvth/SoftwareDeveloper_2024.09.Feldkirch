package Thiemo.week09.Zoo;

import java.util.Vector;

public class Zookeeper {
    private String name;
    private String gender;
    private int age;
    private int HP;
    private int SP;
    private int dangerLevel;
    private Vector<Enclosure> taskList;

    public Zookeeper(String name, String gender, int age, int HP, int SP, int dangerLevel) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.HP = HP;
        this.SP = SP;
        this.dangerLevel = dangerLevel;
        this.taskList = new Vector<>();
    }

    public void addEnclosureTasks(Enclosure enclosure) {
        if (taskList.contains(enclosure)) {
            return;
        }
        taskList.add(enclosure);
    }

    public void simulateDayKeeper(int day) {
        for (Enclosure enc : taskList) {
            if (enc.getGotfeedby() == null) {
                System.out.println( name + " feeds the animals in " + enc.getName());
                enc.setGotfeedby(name);
            } else {
                System.out.println(enc.getName() + " got already feeded by:" + enc.getGotfeedby());
            }
            if (enc.getCleanedBy() == null) {
                System.out.println( name + " cleans " + enc.getName());
                enc.setCleanedBy(name);
            } else {
                System.out.println(enc.getName() + " got already cleaned by: " + enc.getCleanedBy());
            }
        }
        for (Enclosure enc : taskList) {
            if (day % 2 == 0) {
                enc.resetCleaningStatus();
            }
            enc.resetFeedingStatus();
        }

    }

    public void printKeeper() {
//        System.out.print("├── " + "Keeper: " + name + ", " + gender + ", " + age+" ==>");
        System.out.printf("├── Keeper: %5s , %7s , %5d  ==>", name, gender, age);
        for (Enclosure enc : taskList) {
            System.out.print(" |" + enc.getName());
        }
        System.out.println();
    }
}
