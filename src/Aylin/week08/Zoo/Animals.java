package Aylin.week08.Zoo;

import Gyula.WildColors;

import java.util.HashMap;

public class Animals {
    private String name;
    private String species;
    private int age;
    private String gender;
    private Food food;
    private double amount;

    public Animals(String name, String species, int age, String gender, Food food, double amount) {
        this.name = WildColors.getColorFromHSL(205, 1.0, 0.4) + name + WildColors.resetColor();
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.food = food;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void printAnimals() {
        System.out.println("│       ├── " + name + ", " + species);
    }

    @Override
    public String toString() {
        return species + ", named as: " + name + " (" + age + ")/ " + gender;
    }

    // Collects food requirements for the animal
    public void collectFoodRequirement(HashMap<Food, Double> foodRequired) {
        if (foodRequired.containsKey(food)) {
            foodRequired.put(food, foodRequired.get(food) + amount);
        } else {
            foodRequired.put(food, amount);
        }
    }
}
