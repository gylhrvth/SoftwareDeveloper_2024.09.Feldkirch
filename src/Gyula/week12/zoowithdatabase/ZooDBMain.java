package Gyula.week12.zoowithdatabase;

import Gyula.WildColors;
import Gyula.week09.zoo.Zoo;

public class ZooDBMain {
    public static void main(String[] args) {
        Zoo tierpark = new Zoo("Tierpark Feldkirch", 1978);

        tierpark.searchAndCreateZooKeeper("Thiemo", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Savanna", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Giraffehaus", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Savanna", "chicken");

        DBManager.getInstance().readAllAnimalsFromDatabase(tierpark);

        tierpark.printStructure();
        System.out.println();

        for (int day = 1; day <= 10; day++) {
            tierpark.simulateDay(day);
            System.out.println();
        }

        System.out.println(WildColors.getColor("#EF1177") + "Game Over" + WildColors.resetColor());


    }
}
