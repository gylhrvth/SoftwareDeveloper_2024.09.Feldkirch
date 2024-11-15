package Thiemo.week09.Zoo;

import java.util.Random;
import java.util.Vector;

public class Vet {
    private static Random random = new Random();
    private String name;
    private String gender;
    private int age;
    private int HP;
    private int SP;
    private int dangerLevel;
    private Vector<Enclosure> taskList;
    private String mostLikedAnimal;

    public Vet(String name, String gender, int age, int HP, int SP, int dangerLevel, String mostLikedAnimal) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.HP = HP;
        this.SP = SP;
        this.dangerLevel = dangerLevel;
        this.taskList = new Vector<>();
        this.mostLikedAnimal = mostLikedAnimal;
    }


    public void addEnclosureTasksvet(Enclosure enclosure) {
        if (taskList.contains(enclosure)) {
            return;
        }
        taskList.add(enclosure);
    }

    public void simulateDayVet() {

//                  // get 1 random enclosure

        Enclosure randomEnclosure = taskList.get(random.nextInt(taskList.size()));
        System.out.println(name + " walks over to " + randomEnclosure.getName());
        randomEnclosure.simulateDayEnclosureVet(this);

//                  // go to every enclosure and get 1 animal
//
//                for (Enclosure enc : taskList) {
//        System.out.println(name + " walks over to " + randomEnclosure.getName());
//        randomEnclosure.simulateDayEnclosureVet(this);
//    }
    }

    public String getName() {
        return name;
    }

    public int getSP() {
        return SP;
    }

    public String getMostLikedAnimal() {
        return mostLikedAnimal;
    }
}

