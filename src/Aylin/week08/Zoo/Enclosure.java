package Aylin.week08.Zoo;

import Sandro.Colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Enclosure {
    private String name;
    private double size;
    private int capacity;
    private List<Animals> animalList;
    private String description;
    private List<Zookeeper> zookeeperList;

    public Enclosure (String name, double size, int capacity, String description){
        this.name = name;
        this.size = size;
        this.capacity = capacity;
        this.animalList = new Vector<>();
        this.description = description;
        this.zookeeperList = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void addAnimals(Animals animal){

        if(!animalList.contains(animal)){
            animalList.add(animal);
        }
    }

    @Override
    public String toString() {
        return name + ", " + description + ", size: " + size + ", capacity: " + capacity;
    }

    public void printEnclosure(){
        System.out.println("│   ├── " + name + ", " + description );

        if(animalList.isEmpty()){
            System.out.println("│         ├─── empty");
        }
        for (Animals ani : animalList){
            ani.printAnimals();
        }
    }

    public void collectFoodRequirement(HashMap<Food, Double> foodRequired){
        for (Animals a : animalList){
            a.collectFoodRequirement(foodRequired);
        }
    }

    public void addZookeeper(Zookeeper zookeeper){
        if(!zookeeperList.contains(zookeeper)){
            zookeeperList.add(zookeeper);
        }
    }
}
