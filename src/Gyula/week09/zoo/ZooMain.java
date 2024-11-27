package Gyula.week09.zoo;

import Gyula.WildColors;

public class ZooMain {
    public static void main(String[] args) {
        Zoo tierpark = new Zoo("Tierpark Feldkirch", 1978);

        tierpark.searchAndCreateZooKeeper("Thiemo", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Savanna", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Giraffehaus", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Savanna", "chicken");


        tierpark.searchAndCreateAnimal("Savanna", "Nuggets", "chicken", "♂", 200, 10);
        tierpark.searchAndCreateAnimal("Savanna", "Tatar", "beef","♂", 200, 100);
        tierpark.searchAndCreateAnimal("Savanna", "Steak", "beef", "♀", 100, 5);
        tierpark.searchAndCreateAnimal("Aquarium", "Nemo", "guppy", "♀", 10, 1);

        tierpark.searchAndCreateAnimal("Giraffehaus", "George", "giraffe", "♂", 200, 100);
        for (int i = 1; i <= 20; i++) {
            tierpark.searchAndCreateAnimal("Giraffehaus", "Marta " + String.format("%03d", i), "mosquito", "♀", (i ==7?5:1), 5);
        }


        tierpark.printStructure();
        System.out.println();

        for (int day = 1; day <= 10; day++) {
            tierpark.simulateDay(day);
            System.out.println();
        }

        System.out.println(WildColors.getColor("#EF1177") + "Game Over" + WildColors.resetColor());

    }
}
