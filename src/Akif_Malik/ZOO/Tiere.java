package Akif_Malik.ZOO;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.Random;

public class Tiere {
    Random random = new Random();

    private String name;
    private String description;
    private int health;
    private int maxHealth;
    private int attack;

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
        if ((random.nextInt(100) < 40) &&
                        this.isAlive() &&
                        victim.isAlive()) {
            victim.health -= this.attack;
            System.out.print(WildColors.getColor("#DC31A3") + this + " has biten " + victim + "." + WildColors.resetColor());
            if (victim.health > 0) {
                System.out.println(WildColors.getColor("#A41AEE") + " " + victim + " has " + victim.health + " HP left." + WildColors.resetColor());
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
