package Gyula.week09.zoo;

import Gyula.WildColors;

import java.util.Vector;

public class ZooKeeper {
    private String name;
    private Vector<Enclosure> taskList;

    public ZooKeeper(String name){
        this.name = name;
        this.taskList = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void addTask(Enclosure task){
        if (!taskList.contains(task)){
            taskList.add(task);
        }
    }

    public void printStructure(){
        System.out.printf("    %s resonsible for: ", this);
        for (int i = 0; i < taskList.size(); i++) {
            if (i > 0){
                System.out.print(", ");
            }
            System.out.print(taskList.get(i));
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return WildColors.getColorFromHSL(30, 1.0, 0.4) + name + WildColors.resetColor();
    }

}
