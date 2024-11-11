package Gyula.week09.zoo;

public class ZooMain {
    public static void main(String[] args) {
        Zoo tierpark = new Zoo("Tierpark Feldkirch", 1978);

        tierpark.searchAndCreateAnimal("Savanna", "Nuggets", "chicken", "♂");
        tierpark.searchAndCreateAnimal("Savanna", "Tatar", "beef","♂");
        tierpark.searchAndCreateAnimal("Savanna", "Steak", "beef", "♀");
        tierpark.searchAndCreateAnimal("Aquarium", "Nemo", "guppy", "♀");

        tierpark.printStructure();
    }
}
