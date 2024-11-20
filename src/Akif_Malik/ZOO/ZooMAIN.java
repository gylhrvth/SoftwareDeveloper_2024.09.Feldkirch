package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo tiergartenDornbirn = new Zoo("Tiergarten Dornbirn", 2022);

        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Nugget", "chicken", "♂", 200, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Tatar", "beef", "♂", 200, 15);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Astro", "beef", "♀", 100, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Lion", "beef", "♂", 300, 20);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Tiger", "beef","♀", 500, 30);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Wolf", "beef", "♂", 250, 20);

        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Blubber", "fish", "♀", 15, 1);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Puffer", "fish", "♀", 30, 2);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Shark", "fish", "♂", 300, 1);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Baby Whale", "fish", "♂", 1000, 0);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Forelle", "fish","♂", 50, 1);

        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Monke", "monkey", "♀", 125, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "KONG", "monkey", "♀", 250, 20);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Gorilla", "monkey", "♀", 345, 35);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Koook", "monkey", "♂", 105, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Nuke", "monkey", "♂", 1000, 1);
        tiergartenDornbirn.searchAndCreateAnimal("Jungle", "Furball", "monkey", "♀", 185, 5);
        //------------------------------------------------------------------------------------------------------------------------------------------\\
        tiergartenDornbirn.searchAndCreateZooKeeper("Ubi", "Aquarium", "beef");
        tiergartenDornbirn.searchAndCreateZooKeeper("Enes", "Savanna", "chicken");
        tiergartenDornbirn.searchAndCreateZooKeeper("Seyda", "Jungle", "beef");
        tiergartenDornbirn.searchAndCreateZooKeeper("Akif", "Aquarium", "fish");
        //------------------------------------------------------------------------------------------------------------\\
        Doctor a = new Doctor("|Intern|");

        for (int day = 1; day < 5; day++) {
            tiergartenDornbirn.simulateDay(day);
            System.out.println();
        }
    }
}