package Furkan.week09.Zoo;

import java.util.HashMap;
import java.util.Random;

public class Tier {
    private Random random = new Random();

    private String name;
    private String gattung;
    private Food food;
    private double amount;
    private int hungerCycle;
    private int hungerStatus;
    private String healthStatus = "gesund";

    private int health;
    private int maxHealth;
    private int attack;



    public Tier(String name, String gattung, Food food, int amount, int hungerCycle, int maxhealth, int attack) {
        this.name = name;
        this.gattung = gattung;
        this.food = food;
        this.amount = amount;
        this.hungerCycle = hungerCycle;
        this.hungerStatus = hungerCycle;
        this.health = maxhealth;
        this.maxHealth = 200;
        this.attack = attack;
    }

    public int getHungerStatus() {
        return hungerStatus;
    }

    public int getHungerCycle() {
        return hungerCycle;
    }

    public String getName() {
        return name;
    }

    public String getGattung() {
        return gattung;
    }

    public void simu() {
        if (hungerStatus >= hungerCycle) {
            System.out.println(name + " ist hungrig und frisst alles auf.");
            hungerStatus = 1;
        } else
            System.out.println(name + " ist satt und chillt.");

        System.out.println();
    }

    public void tagVergeht() {
        hungerStatus++;
    }

    public boolean isAlive() {
        return health > 0;
    }


    public void collectFoodRequirement(HashMap<Food, Double> foodRquiert) {
        if (foodRquiert.containsKey(food)) {
            foodRquiert.put(food, foodRquiert.get(food) + amount);
        } else {
            foodRquiert.put(food, amount);
        }
    }

    public Food getFood() {
        return food;
    }

    public void simulateFight(Tier victim) {
        if( (random.nextInt(100) < 40) &&
            this.isAlive() &&
            victim.isAlive()) {
            victim.health -= this.attack;
            System.out.println(this + " has bitten the" + victim + ".");

            if (victim.health >0){
                System.out.println(" " +victim + " has " + victim.health + "HP left.");
            } else {
                System.out.println(" " + victim + "died RIP.");
            }
        }

    }


    public String getHealthStatus() {
        return healthStatus;
    }


}
