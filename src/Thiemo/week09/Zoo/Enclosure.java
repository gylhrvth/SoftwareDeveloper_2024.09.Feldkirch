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
    private Vector<Animal> deadAnimallist;
    private String cleanedBy = null;
    private String gotfeedby = null;
    private boolean workdone;


    public Enclosure(String name, int maxCapacityAnimals, String indoorOrOutdoor) {
        this.name = name;
        this.maxCapacityAnimals = maxCapacityAnimals;
        this.indoorOrOutdoor = indoorOrOutdoor;
        this.animalList = new Vector<>();
        this.deadAnimallist = new Vector<>();
        this.workdone = false;
    }

    public void addDeadAnimals(Animal animal) {
        deadAnimallist.add(animal);
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


    public void simulateDayEnclosurefight() {
        System.out.println("\nIn Enclosure " + name + ":");

        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);

//        for (Animal animal : animalList)       //makes an java.util.ConcurrentModificationException because ich remove one animal

            Animal randomAnimal = animalList.get(random.nextInt(animalList.size()));

            if (!randomAnimal.getName().equals(animal.getName()) && animalList.size() >= 2 && random.nextInt(100) > 50 && randomAnimal.getHP() > 0 && animal.getHP() > 0) {

                System.out.println("Animal " + animal.getName() + " attacks " + randomAnimal.getName());
                animal.simulateFights(animal, randomAnimal);

            } else if (animalList.size() <= 1) {
                System.out.println(animal.getName() + " does nothing and chills");
            } else if (animal.getHP() <= 0) {
                System.out.println(Colors.COLORS[3] + animal.getName() + " is dead" + Colors.RESET);
            } else {
                System.out.println(animal.getName() + "......");
            }
        }
    }

    public void removeDeadAnimals() {
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            if (animal.getHP() <= 0) {
                addDeadAnimals(animal);
                removeAnimals(animal);
            }
        }
    }

    public void simulateDayEnclosureVet(Vet vet) {

        System.out.println(vet.getName() + " tries to heal the animals in " + name + "\n");

        String vetMostLikedAnimal = vet.getMostLikedAnimal();
        if (animalList.contains(vetMostLikedAnimal)) {
            System.out.println("====================================");
        }

//                      // heal 1 randomAnimal

        Animal randomAnimal = animalList.get(random.nextInt(animalList.size()));
        randomAnimal.simulateHealing(randomAnimal, vet);


//          // heal 1 random animal per enclosure

//        if (random.nextInt(100) > 50) {
//            randomAnimal.simulateHealing(randomAnimal, vet);
//        } else {
//            System.out.println("no heal for the animals");


//              // heal every Animal in enclosure

//            for (Animal animal : animalList) {
//
//                if (random.nextInt(100) > 50) {
//                    animal.simulateHealing(animal, vet);
//                } else {
//                    System.out.println("no heal for " + animal.getName());
//                }
//    }
        System.out.println("\n");
    }

    public void displayDeadAnimals() {
        for (Animal deadAnimal : deadAnimallist) {
            System.out.println(deadAnimal.getName() + " DEAD");
        }
    }


    public String getCleanedBy() {
        return cleanedBy;
    }

    public void setCleanedBy(String cleanedBy) {
        this.cleanedBy = cleanedBy;
    }

    public boolean isWorkdone() {
        return workdone;
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

    public void resetworkdone() {
        this.workdone = false;
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


    public void simulateDayEnclosureKeeper(Zookeeper zookeeper) {
        System.out.println(zookeeper.getName()+" checks if in "+ name + " is something to do");
        if (workdone) {
            System.out.println("the job in "+name+" is already done by " + zookeeper.getName());
        } else {
            System.out.println(zookeeper.getName() + " walks over to " + name);
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
            workdone = true;
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
