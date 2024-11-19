package Akif_Malik.ZOO;

import Sandro.Colors;

import java.util.Random;

public class Tiere {

    private String name;
    private String description;
    private int health;
    private int maxHealth;
    private int attack;

    Random random = new Random();

    public Tiere(String name, String description, int maxHealth, int attack) {
        this.name = name;
        this.description = description;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void printStructure() {
        System.out.printf("        Animal: %s %s HP: %d\n", this, health);
    }

    public void simulateFight(Tiere victim) {
        if (
                (random.nextInt(100) < 40) &&
                        this.isAlive() &&
                        victim.isAlive()) {
            victim.health -= this.attack;
            System.out.print(this + " has biten " + victim + ".");
            if (victim.health > 0) {
                System.out.println(" " + victim + " has " + victim.health + " HP left.");
            } else {
                System.out.println(" " + victim + " RIP.");
            }
        }
    }

    @Override
    public String toString() {
        return Colors.COLORS[3] + name + ", " + description + Colors.RESET;
    }
}
