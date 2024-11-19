package Akif_Malik.ZOO;

import Gyula.WildColors;

import java.util.Vector;

public class ZooKeeper {
    private String name;
    private Vector<Akif_Malik.ZOO.Enclosure> taskList;
    private String favoriteSpecies;
    private Vector<ZooKeeper> zooKeepers;

    public ZooKeeper(String name, String favoriteSpecies) {
        this.name = name;
        this.favoriteSpecies = favoriteSpecies;
        this.taskList = new Vector<>();
        this.zooKeepers = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public String getFavoriteSpecies() {
        return favoriteSpecies;
    }

    public void addTask(Akif_Malik.ZOO.Enclosure task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void printStructure() {
        System.out.printf("    %s resonsible for: ", this);
        for (int i = 0; i < taskList.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(taskList.get(i));
        }
        System.out.println();
    }

    public void addZooKeeper(ZooKeeper keeperName) { zooKeepers.add(keeperName); }

    public void simulateDay() {
        if (taskList.isEmpty()) {
            System.out.printf("%s has no assigned enclosure.\n", this);
            return;
        }
        for (Enclosure enclosure : taskList) {
            enclosure.simulateDay(this);
        }
    }

    @Override
    public String toString() {
        return WildColors.getColor("#abcdef") + name + WildColors.resetColor();
    }
}
