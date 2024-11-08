package Sandro.Week8.ZooTycoon;

import java.util.HashMap;

public class Animal {
    private String name;
    private int age;
    private String genus;
    //new
    private Food food;
    private double amount;


    public Animal(String name, int age, String genus, Food food, int amount) {
        this.name = name;
        this.age = age;
        this.genus = genus;
        //new
        this.food = food;
        this.amount = amount;
    }




    public void simu() {
        System.out.println("Was macht das Tier --> "+name);
    }


    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        //Hashmap befüllen mit aktuellen Informationen
        //wenn Hashmap aktuelles Food beinhaltet, dann ...
        if (foodRequiert.containsKey(food)) {
            //Hashmap.put (Food, hashmap.get(food) + amount
            foodRequiert.put(food, foodRequiert.get(food) + amount);
            //wenn Hashmap aktuelles Food noch nicht beinhaltet, dann...
        } else {
            //Hashmap.put (Food, amount)
            foodRequiert.put(food, amount);
        }
    }



    public void printZooStructure() {
        //print alle Attribute der klasse
        System.out.println("│   │   ├── Animal: " + name + ", " + genus + " Years: " + age);
    }


}
