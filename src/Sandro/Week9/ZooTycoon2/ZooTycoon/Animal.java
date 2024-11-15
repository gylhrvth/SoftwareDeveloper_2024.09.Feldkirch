package Sandro.Week9.ZooTycoon2.ZooTycoon;

import lukas.week03.day4.Colors;

import java.util.HashMap;
import java.util.Random;

public class Animal {
    private String name;
    private String genus;
    private Food food;
    private double amount;
    private int currentHealth;
    private int maxHealth;
    //   private int healthprecent;
    private int dmgPerBite;
    private int critDmg;


    static Random rand = new Random();

    public Animal(String name, String genus, Food food, double amount, int currentHealth, int maxHealth, int dmgPerBite) {
        this.name = Colors.COLORS[5] + name + Colors.RESET;
        this.genus = genus;
        this.food = food;
        this.amount = amount;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.dmgPerBite = dmgPerBite;
        this.critDmg = dmgPerBite + dmgPerBite / 2;
        //   this.healthprecent = (maxHealth/100) *currentHealth;
    }

    public int getDmgPerBite() {
        return dmgPerBite;
    }

    public int getCritDmg() {
        return critDmg;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void animalGetsHeal(Animal animal) {
        Animal ani = animal;
        ani.currentHealth = ani.maxHealth;
    }


    public void heal(Vet vet){
        int procentheal = rand.nextInt(30, 100);
        int heal = Math.max(10, (int)(maxHealth * procentheal / 100.0));
        System.out.println(name + " (Health: " + currentHealth + "/" + maxHealth + ")");

        currentHealth = Math.min(maxHealth, currentHealth + heal);
        String midText = "complete (" + procentheal + "%)";
        if (currentHealth != maxHealth) {
            midText = "for: " + heal + "HP(" + procentheal + "%)";
        }
        System.out.println(name + " gets healed " + midText + " from " + vet.getName() + " / " + name + " has now --> (Health: " + currentHealth + "/" + maxHealth + ")");
    }


    public int getHealthprecent() {
        return (int) (100.0 / maxHealth * currentHealth);
    }

    public void feedAnimal(Animal animal) {
        Animal ani = animal;
        int healFromFood = (ani.maxHealth / 50);
        int critHealFromFood = (ani.maxHealth / 25);
        int critTrigger = rand.nextInt(0, 100);


        if (ani.currentHealth < ani.maxHealth) {

            if (critTrigger > 10) {
                ani.currentHealth += healFromFood;
                if (ani.currentHealth > ani.maxHealth) {
                    ani.currentHealth = ani.maxHealth;
                }
                System.out.println(ani.name + Colors.COLORS[2] + " heals " + Colors.RESET + "for: " + healFromFood + "(Health: " + ani.getCurrentHealth() + "\\" + ani.maxHealth + ")");
            } else {
                ani.currentHealth += critHealFromFood;
                if (ani.currentHealth > ani.maxHealth) {
                    ani.currentHealth = ani.maxHealth;
                }
                System.out.println(Colors.COLORS[1] + "CRITICAL Heal " + Colors.RESET + ani.name + Colors.COLORS[2] + " heals " + Colors.RESET + "for: " + critHealFromFood + "(Health: " + ani.getCurrentHealth() + "\\" + ani.maxHealth + ")");
            }

        }
    }

    //todo print current life till fight
    public void animalfight(Animal vict, Animal aggro) {
        int fighttime = rand.nextInt(1, 5);

        if (!vict.isAlive() || !aggro.isAlive()){
            return;
        }


        for (int i = 0; i < fighttime; i++) {
            System.out.println("Round: " + (i + 1));
            animalgetsBit(aggro, vict);
            System.out.println(vict.name + "(" + vict.getHealthprecent() + "%)" + " bites" + aggro.name + "(" + aggro.getHealthprecent() + ")%");
            if (!vict.isAlive() || !aggro.isAlive()) {
                return;
            }
            animalgetsBit(vict, aggro);
            System.out.println(aggro.name + "(" + aggro.getHealthprecent() + "%)" + " bites " + vict.name + " (" + vict.getHealthprecent() + "%)");

            if (!vict.isAlive() && aggro.isAlive()) {
                System.out.println(vict.name + " died in the Fight!");
                System.out.println(aggro.name + " wins the Fight and is the Boss in the Enclosure");
                return;
            }

            if (vict.isAlive() && !aggro.isAlive()) {
                System.out.println(aggro.name + " died in the Fight!");
                System.out.println(vict.name + " wins the Fight and is the Boss in the Enclosure");
                return;
            }
        }
    }

    public void animalgetsBit(Animal victim, Animal aggresor) {
        int critTrigger = rand.nextInt(0, 100);
        Animal vic = victim;
        Animal agr = aggresor;

        if (!vic.isAlive() || !agr.isAlive()){
            return;
        }
        if (critTrigger > 5) {
            System.out.println(agr.name + " bites " + vic.name + " for " + dmgPerBite + " Damage");
            vic.currentHealth = vic.currentHealth - agr.getDmgPerBite();
            vic.setCurrentHealth(vic.currentHealth);
        } else {
            System.out.println(Colors.COLORS[1] + "CRITICAL HIT " + Colors.RESET + agr.name + " bites " + vic.name + " for --> " + critDmg + " Damage");
            vic.currentHealth = vic.currentHealth - agr.getCritDmg();
            vic.setCurrentHealth(vic.currentHealth);
        }
    }


    public Food getFood() {
        return food;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        if (foodRequiert.containsKey(food)) {
            foodRequiert.put(food, foodRequiert.get(food) + amount);
        } else {
            foodRequiert.put(food, amount);
        }
    }

    public void printZoo() {
        System.out.println("│   │   ├── Animal: " + name + ", " + genus + "Health: " + currentHealth + "\\" + maxHealth);
    }

    @Override
    public String toString() {
        return name + ": " + getHealthprecent() + "%";
    }


    Animal findlowestAnimal(Animal bestChoise) {
        if (bestChoise == null){
            return this;
        } else if (this.getHealthprecent() < bestChoise.getHealthprecent()){
            bestChoise = this;
        }
        return bestChoise;
    }
}
