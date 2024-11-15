package Thiemo.week09.Zoo;

import java.util.Vector;

public class Vet {
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
//        for (int i = 0; i <taskList.size(); i++) {
//            Animal animat = ;
        for (Enclosure enc : taskList) {
            System.out.println(name + " walks over to " + enc.getName());
//            enc.simulateDayEnclosureVet(this);

        }
    }

    public String getName() {
        return name;
    }

    public int getSP() {
        return SP;
    }
}

