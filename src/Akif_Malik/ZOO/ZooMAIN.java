package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo tiergartenDornbirn = new Zoo("Tiergarten Dornbirn", 2022);

        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Asteroid Destroyer", "chicken", "♂", 200, 1000);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Tatar", "beef", "♂", 200, 50);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Astro", "beef", "♀", 100, 25);

        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Blubber", "fish", "♀", 15, 1);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Puffer", "fish", "♀", 30, 2);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Shark", "fish", "♂", 300, 1);

        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Monke", "monkey", "♀", 125, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "KONG", "monkey", "♀", 250, 50);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Gorilla", "monkey", "♀", 345, 65);
        //------------------------------------------------------------------------------------------------------------------------------------------\\
        tiergartenDornbirn.searchAndCreateZooKeeper("Akif", "Aquarium", "chicken");
        tiergartenDornbirn.searchAndCreateZooKeeper("Enes", "Savanna", "chicken");
        tiergartenDornbirn.searchAndCreateZooKeeper("Seyda", "Jungle", "monkey");
        tiergartenDornbirn.searchAndCreateZooKeeper("Ubi", "Jungle", "fish");


        for (int day = 1; day < 11; day++) {
            tiergartenDornbirn.simulateDay(day);
            System.out.println();
        }
    }
}