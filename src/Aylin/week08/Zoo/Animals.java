package Aylin.week08.Zoo;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.HashMap;
import java.util.Random;

public class Animals {
    public static Random random = new Random();
    private String name;
    private String species;
    private int age;
    private String gender;
    private Food food;
    private double amount;
    private int health;
    private int maxHealth;
    private int bite;

    public Animals(String name, String species, int age, String gender, Food food, double amount, int health, int maxHealth, int bite) {
        this.name = WildColors.getColorFromHSL(205, 1.0, 0.4) + name + WildColors.resetColor();
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.food = food;
        this.amount = amount;
        this.health = health;
        this.maxHealth = maxHealth;
        this.bite = bite;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
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

    public void feedAnimals(Zookeeper zookeeper){
        if (random.nextInt(100) < 5) {
            System.out.println(Colors.COLORS[1] + "(SIDE NOTE: " + zookeeper.getName() + " forgot to feed " + name + ")" + Colors.RESET);
        } else {
            System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + zookeeper.getName() + WildColors.resetColor() + " feeds " + name + ".");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        if(health > maxHealth){
            this.health = maxHealth;
        }else if(health < 0){
            this.health = 0;
        }else{
            this.health = health;
        }
    }

    public int getBite() {
        return this.bite;
    }

    public void applyDamage(int damage){
        int newHealth = health - damage;
        System.out.println(name + " now has a health of " + newHealth + " after taking " + damage + " damage.");
    }

    public boolean isAlive(){
        return health > 0;
    }
}
