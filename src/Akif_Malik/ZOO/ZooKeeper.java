package Akif_Malik.ZOO;

import Gyula.WildColors;

import java.util.Vector;

public class ZooKeeper {
    private String name;
    private Vector<Gehege> taskList;
    private String favoriteSpecies;

    public ZooKeeper(String name, String favoriteSpecies){
        this.name = name;
        this.taskList = new Vector<>();
        this.favoriteSpecies = favoriteSpecies;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteSpecies() {
        return favoriteSpecies;
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

    /*public void simulateDay(){
        if (taskList.isEmpty()){
            System.out.printf("%s has no assigned enclosure...\n", this);
            return;
        }
        for (Gehege gh: taskList){
            gh.simulateDay(this);
        }
    }
     */

    @Override
    public String toString() { return WildColors.getColor("#abcdef") + name + WildColors.resetColor();}
}
