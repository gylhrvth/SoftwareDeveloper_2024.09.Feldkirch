package Aylin.week08.Zoo;

import Gyula.WildColors;
import Gyula.week09.zoo.Animal;
import Sandro.Colors;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

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
    private Vector<Animal> animalList;

    public Animals(String name, String species, int age, String gender, Food food, double amount, int health, int bite) {
        this.name = WildColors.getColorFromHSL(205, 1.0, 0.4) + name + WildColors.resetColor();
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.food = food;
        this.amount = amount;
        this.health = health;
        this.maxHealth = 100;
        this.bite = bite;
        this.animalList = new Vector<>();
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
            System.out.println(Colors.COLORS[2] + "(SIDE NOTE: " + zookeeper.getName() + " forgot to feed " + name + ")" + Colors.RESET);
        } else {
            System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + zookeeper.getName() + WildColors.resetColor() + " feeds " + name + ".");
        }
    }

    public int getHealth() {
        return health;
    }

    public int getBite() {
        return this.bite;
    }

    public void applyDamage(int damage){
        this.health -= damage;
        if(this.health < 0){
            this.health = 0;
        }
        System.out.println(name + " now has a health of " + this.health + " after taking " + damage + " damage.");
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void fightClub(Animals defender) {
        if (random.nextInt(100) < 40) {
            System.out.println(this.name + " gets aggressive and bites " + defender.getName() + ".");
            int damage = this.getBite();
            defender.applyDamage(damage);
            if (!defender.isAlive()) {
                System.out.println(defender.getName() + " is dead because of the damage he got.");
            }
        } else {
            System.out.println("The animals are playing together.");
        }
    }
}
