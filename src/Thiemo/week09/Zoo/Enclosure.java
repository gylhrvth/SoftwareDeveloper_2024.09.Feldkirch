package Thiemo.week09.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Enclosure {
    private static Random random = new Random();
    private String name;
    private int maxCapacityAnimals;
    private String indoorOrOutdoor;
    private Vector<Animal> animalList;
    private String cleanedBy = null;
    private String gotfeedby = null;


    public Enclosure(String name, int maxCapacityAnimals, String indoorOrOutdoor) {
        this.name = name;
        this.maxCapacityAnimals = maxCapacityAnimals;
        this.indoorOrOutdoor = indoorOrOutdoor;
        this.animalList = new Vector<>();
    }

    public void addAnimals(Animal animal) {
        if (animalList.contains(animal)) {
            return;
        }
        animalList.add(animal);
    }

    public void removeAnimals(Animal animal) {
        animalList.remove(animal);
    }

    public void printEnclosure() {
        System.out.println("│   ├── " + Colors.COLORS[3] + name + Colors.RESET + " maxCap:" + maxCapacityAnimals + " " + indoorOrOutdoor);
        if (animalList.isEmpty()) {
            System.out.println("│   │   ├── is empty");
        } else {
            for (Animal ani : animalList) {
                ani.printAnimal();
            }
        }
    }

    public void collectFood(HashMap<Food, Double> foodrequiert) {
        for (Animal animal : animalList) {
            animal.collectFood(foodrequiert);
        }
    }

    public void simulateDayEnclosure(int day) {

        System.out.println("In Enclosure " + name + " happens whut?");
        for (Animal animal : animalList) {
            animal.simulateDayAnimal(day);
        }
    }

    public String getCleanedBy() {
        return cleanedBy;
    }

    public void setCleanedBy(String cleanedBy) {
        this.cleanedBy = cleanedBy;
    }

    public String getName() {
        return name;
    }

    public void resetCleaningStatus() {
        this.cleanedBy = null;
    }

    public String getGotfeedby() {
        return gotfeedby;
    }

    public void setGotfeedby(String gotfeedby) {
        this.gotfeedby = gotfeedby;
    }

    public void resetFeedingStatus() {
        this.gotfeedby = null;
    }

    public void simulateDayEnclosure(String name) {
        if (getGotfeedby() == null) {
            System.out.println(name + " feeds the animals in " + getName());
            for (Animal animal : animalList) {
                animal.simulateDayAnimalfeeding();
                setGotfeedby(name);
            }

        } else {
            System.out.println("The animals in "+ getName() + " got already fed by: " + getGotfeedby());
        }

        if (getCleanedBy() == null) {
            System.out.println(name + " cleans " + getName());
            setCleanedBy(name);
        } else {
            System.out.println(getName() + " got already cleaned by: " + getCleanedBy());
        }
    }


    @Override
    public String toString() {
        return "Enclosure: " +
                "name = " + name +
                ", maxCapacityAnimals = " + maxCapacityAnimals +
                ", indoorOrOutdoor = " + indoorOrOutdoor;

    }
}
