package Aylin.week08.Zoo;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Enclosure {
    public static Random random = new Random();

    private String name;
    private double size;
    private int capacity;
    private Vector<Animals> animalList;
    private String description;
    private boolean processedToday;

    public Enclosure(String name, double size, int capacity, String description) {
        this.name = name;
        this.size = size;
        this.capacity = capacity;
        this.animalList = new Vector<>();
        this.description = description;
        this.processedToday = false;
    }

    public String getName() {
        return name;
    }

    public void addAnimals(Animals animal) {
        if (!animalList.contains(animal)) {
            animalList.add(animal);
        }
    }

    @Override
    public String toString() {
        return name + ", " + description + ", size: " + size + ", capacity: " + capacity;
    }

    // Prints the enclosure's details
    public void printEnclosure() {
        System.out.println("│   ├── " + name + ", " + description);

        if (animalList.isEmpty()) {
            System.out.println("│         ├─── empty");
        }
        for (Animals ani : animalList) {
            ani.printAnimals();
        }
    }

    // Collects food requirements for the animals in the enclosure
    public void collectFoodRequirement(HashMap<Food, Double> foodRequired) {
        for (Animals a : animalList) {
            a.collectFoodRequirement(foodRequired);
        }
    }

    public void observeRandomAnimal(Zookeeper zookeeper){
        Animals randomAnimal = animalList.get(random.nextInt(animalList.size()));
        if (randomAnimal.getName().equals(zookeeper.getFavAnimal())){
            System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + zookeeper.getName() + WildColors.resetColor() + " admires his fav. animal " + randomAnimal.getName() + ".");
        }
        System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + zookeeper.getName() + WildColors.resetColor() + " observes " + randomAnimal.getName() + ".");
    }

    public void resetProcess(){
        processedToday = false;
    }

    public void dailyTasks(Zookeeper zookeeper){
        if(random.nextInt(100) < 5){
            System.out.println(Colors.COLORS[1] + zookeeper.getName() + " forgot to visit the " + name + " enclosure." + Colors.RESET);
        }else{
            if (processedToday) {
                System.out.println(name + " was visited today.");
            }else {
                System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + zookeeper.getName() + WildColors.resetColor() + " visits the " + name + " enclosure.");
                processedToday = true;
                for (Animals animals : animalList) {
                    animals.feedAnimals(zookeeper);
                }
                observeRandomAnimal(zookeeper);
            }
        }
    }
}
