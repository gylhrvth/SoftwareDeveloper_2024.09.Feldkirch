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

    public void simulateDayEnclosure() {
        System.out.println("\nIn Enclosure " + name + ":");
        for (Animal animal : animalList) {
            Animal randomAnimal = animalList.get(random.nextInt(animalList.size()));
            if (randomAnimal != animal && animalList.size() > 2 && random.nextInt(100) > 50) {
                System.out.println("Animal " + animal.getName() + " attacks " + randomAnimal.getName());
                animal.simulatefights(animal, randomAnimal);
                if (randomAnimal.getHP() <= 0) {
//                    removeAnimals(randomAnimal);
                }


            } else if (animalList.size() <= 2) {
                System.out.println(animal.getName() + " does nothing and chills");
            } else {
                System.out.println(animal.getName() + ".....");
            }

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

    public void observerandomanimal(Zookeeper zookeeper) {
        Animal randomAnimal = animalList.get(random.nextInt(animalList.size()));
        if (randomAnimal.getName().equals(zookeeper.getMostLikedAnimal()) || randomAnimal.getGenus().equals(zookeeper.getMostLikedAnimal())) {
            System.out.println(Colors.COLORS[5] + zookeeper.getName() + " admires " + randomAnimal.getName() + Colors.RESET);
        } else {
            System.out.println(zookeeper.getName() + " observes " + randomAnimal.getName());
        }
    }


    public void simulateDayEnclosure(Zookeeper zookeeper) {
        if (getGotfeedby() == null) {
            System.out.println(zookeeper.getName() + " feeds the animals in " + getName());
            for (Animal animal : animalList) {
                animal.simulateDayAnimalfeeding();
                setGotfeedby(zookeeper.getName());
            }

        } else {
            System.out.println("The animals in " + getName() + " got already fed by: " + getGotfeedby());
        }

        observerandomanimal(zookeeper);

        if (getCleanedBy() == null) {
            System.out.println(zookeeper.getName() + " cleans " + name);
            setCleanedBy(name);
        } else {
            System.out.println(getName() + " got already cleaned by: " + getGotfeedby());
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
