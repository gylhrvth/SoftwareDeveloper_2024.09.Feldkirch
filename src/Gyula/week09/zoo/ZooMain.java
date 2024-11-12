package Gyula.week09.zoo;

public class ZooMain {
    public static void main(String[] args) {
        Zoo tierpark = new Zoo("Tierpark Feldkirch", 1978);

        tierpark.searchAndCreateZooKeeper("Thiemo", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Savanna", "chicken");
        tierpark.searchAndCreateZooKeeper("Erik", "Schmetterlinghaus", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Aquarium", "chicken");
        tierpark.searchAndCreateZooKeeper("Aylin", "Savanna", "chicken");


        tierpark.searchAndCreateAnimal("Savanna", "Nuggets", "chicken", "♂");
        tierpark.searchAndCreateAnimal("Savanna", "Tatar", "beef","♂");
        tierpark.searchAndCreateAnimal("Savanna", "Steak", "beef", "♀");
        tierpark.searchAndCreateAnimal("Aquarium", "Nemo", "guppy", "♀");

        tierpark.printStructure();

        for (int day = 1; day <= 3; day++) {
            tierpark.simulateDay(day);
        }
    }
}
