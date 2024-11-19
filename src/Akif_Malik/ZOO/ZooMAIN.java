package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo tiergartenDornbirn = new Zoo("Tiergarten Dornbirn", 2022);

        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Asteroid Destroyer", "chicken", "♂", 200, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Tatar", "beef", "♂", 200, 100);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Astro", "beef", "♀", 100, 5);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Blubber", "guppy", "♀", 10, 1);

        tiergartenDornbirn.searchAndCreateZooKeeper("Akif", "Aquarium", "chicken");
        tiergartenDornbirn.searchAndCreateZooKeeper("Enes", "Savanna", "chicken");

        for (int day = 1; day < 5; day++) {
            tiergartenDornbirn.simulateDay(day);
            System.out.println();
        }
    }
}