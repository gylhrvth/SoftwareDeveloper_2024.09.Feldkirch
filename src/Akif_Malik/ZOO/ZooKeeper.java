package Akif_Malik.ZOO;

import Gyula.WildColors;

import java.util.Vector;

public class ZooKeeper {
    private String name;
    private Vector<Gehege> taskList;

    public ZooKeeper(String name){
        this.name = name;
        this.taskList = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void addTask(Gehege task){
        if (!taskList.contains(task)){
            taskList.add(task);
        }
    }

    public void printStructure(){
        System.out.printf("    %s resonsible for: ", this);
        for (int i = 0; i < taskList.size(); i++) {
            if (i > 0){
                System.out.println(", ");
            }
            System.out.println(taskList.get(i));
        }
        System.out.println();
    }

}
