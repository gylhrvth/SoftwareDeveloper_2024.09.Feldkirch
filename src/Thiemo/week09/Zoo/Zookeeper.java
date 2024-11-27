package Thiemo.week09.Zoo;

import java.util.Random;
import java.util.Vector;

public class Zookeeper {
    private static Random random = new Random();
    private String name;
    private String gender;
    private int age;
    private int HP;
    private int SP;
    private int dangerLevel;
    private Vector<Enclosure> taskList;
    private String mostLikedAnimal;
    private boolean workdone;


    public Zookeeper(String name, String gender, int age, int HP, int SP, int dangerLevel, String mostLikedAnimal) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.HP = HP;
        this.SP = SP;
        this.dangerLevel = dangerLevel;
        this.taskList = new Vector<>();
        this.mostLikedAnimal = mostLikedAnimal;
        this.workdone = false;
    }


    public void addEnclosureTasks(Enclosure enclosure) {
        if (taskList.contains(enclosure)) {
            return;
        }
        taskList.add(enclosure);
    }

    public String getName() {
        return name;
    }


    public void simulateDayKeeper() {
//        for (Enclosure enc : taskList){
//            enc.simulateDayEnclosureKeeper(this);
//
//        }

            Enclosure randomtask = taskList.get(random.nextInt(taskList.size()));
            randomtask.simulateDayEnclosureKeeper(this);

    }


    public String getMostLikedAnimal() {
        return mostLikedAnimal;
    }

    public void printKeeper() {
//        System.out.print("├── " + "Keeper: " + name + ", " + gender + ", " + age+" ==>");
        System.out.printf("├── Keeper: %5s , %7s , %5d  ==>", name, gender, age);
        for (Enclosure enc : taskList) {
            System.out.print(" |" + enc.getName());
        }
        System.out.println();
    }

    public Vector<Enclosure> getTaskList() {
        return taskList;
    }
}
