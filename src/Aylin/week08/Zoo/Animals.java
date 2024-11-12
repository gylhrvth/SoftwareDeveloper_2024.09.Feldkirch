package Aylin.week08.Zoo;

import java.util.HashMap;

public class Animals {
    private String name;
    private String species;
    private int age;
    private String gender;
    private String enclosure;

    private Food food;
    private double amount;


    public Animals(String name, String species, int age, String gender, Food food, double amount){
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.enclosure = enclosure;
        this.food = food;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getEnclosure() {
        return enclosure;
    }
    public void printAnimals(){
        System.out.println("│       ├── " + name + ", " + species);
    }

    @Override
    public String toString() {
        return species + ", named as: " + name + " (" + age + ")/ " + gender;
    }

    public void collectFoodRequirement(HashMap<Food, Double> foodRequired){
        if (foodRequired.containsKey(food)){
            foodRequired.put(food, foodRequired.get(food) + amount);
        }else{
            foodRequired.put(food, amount);
        }
    }
}
