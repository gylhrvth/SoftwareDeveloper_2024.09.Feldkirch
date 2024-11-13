package Gyula.week09.zoo;

import Gyula.WildColors;

import java.util.Random;

public class Animal {
    private Random random = new Random();
    private String name;
    private String species;
    private String gender;
    private int health;
    private int maxHealth;
    private int attack;

    public Animal(String name, String species, String gender, int maxHealth, int attack) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void printStructure(){
        System.out.printf("        Animal: %s %s HP: %d\n", this, gender, health);
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void simulateFight(Animal victim){
        if (
                (random.nextInt(100) < 40) &&
                (!this.name.equals(victim.name)) &&
                this.isAlive() &&
                victim.isAlive()) {
            victim.health -= this.attack;
            System.out.print(this + " has biten " + victim + ".");
            if (victim.health > 0) {
                System.out.println(" " + victim + " has " + victim.health + " HP left.");
            } else {
                System.out.println(" " + victim + " RIP.");
            }
            if (victim.species.equals("giraffe")){
                this.health -= this.attack;
                System.out.println(this + " is get poisoned.");
            }
        }
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return WildColors.getColorFromHSL(210, 1.0, 0.4) + name + " the " + species + WildColors.resetColor();
    }
}
