package Akif_Malik.ZOO;

import Gyula.WildColors;

import java.util.Vector;

public class Doctor {

    private Vector<Enclosure> taskList;
    private String name;
    private Boolean lowestAnimalHealth;

    public Doctor(String name) {
        this.name = name;
        this.taskList = new Vector<>();
        this.lowestAnimalHealth = false;
    }

    public void addTask(Enclosure task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void startDayForDoctor() {
            System.out.println("Doctor " + name + ":" + WildColors.getColor("#8F537B") + "Animals do not need to be healed.\n See you tomorrow :-)");
    }
}
