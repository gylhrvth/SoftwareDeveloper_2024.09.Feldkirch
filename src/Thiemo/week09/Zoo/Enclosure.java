package Thiemo.week09.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class Enclosure {
    private String name;
    private int size;
    private int maxCapacityAnimals;
    private String indoorOrOutdoor;
    private int dangerLevel;
    private Vector<Animal> animalList;

    public Enclosure(String name, int size, int maxCapacityAnimals, String indoorOrOutdoor, int dangerLevel) {
        this.name = name;
        this.size = size;
        this.maxCapacityAnimals = maxCapacityAnimals;
        this.indoorOrOutdoor = indoorOrOutdoor;
        this.dangerLevel = dangerLevel;
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
        System.out.println("│   ├── " + Colors.COLORS[3]+ name +Colors.RESET +"(" + size + "m2) " +"maxCap:"+ maxCapacityAnimals + " " + indoorOrOutdoor + " (" + dangerLevel + ")");
        if (animalList.isEmpty()){
            System.out.println("│   │   ├── is empty");
        }else {
            for (Animal ani : animalList) {
                ani.printAnimal();
            }
        }
    }

    @Override
    public String toString() {
        return "Enclosure: " +
                "name = " + name +
                ", size = " + size + "m2" +
                ", maxCapacityAnimals = " + maxCapacityAnimals +
                ", indoorOrOutdoor = " + indoorOrOutdoor +
                ", dangerLevel = " + dangerLevel;
    }

}
