package Erik.week08.Zoo;

import Gyula.WildColors;
import Gyula.week09.zoo.Animal;
import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Tier {
    public static Random rand = new Random();

    // Attribute
    private String name;
    private String gattung;
    private Vector<Essen> essensListe;
    private Essen food;
    private int amountOfFood;
    private int currentHP;
    private int maxHP;
    private int damage;


    // Konstruktor
    public Tier(String gattung, String name, Essen food, int amountOfFood, int maxHP, int damage) {
        this.gattung = gattung;
        this.name = name;
        this.food = food;
        this.amountOfFood = amountOfFood;
        this.essensListe = new Vector<>();
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.damage = damage;
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public String getGattung() {
        return gattung;
    }

    public int getDamage() {
        return damage;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }


    // Methoden
    public void printTierStructure() {
        System.out.printf("│   │   ├── Tier:  %-10s │ %-10s │ %-15s │ %3d │\n", name, gattung, food.getName(), amountOfFood);
    }

    public void getEveryFood(HashMap<Essen, Integer> neededFood) {

        if (neededFood.containsKey(food)) {                               // Prüft, ob das jeweilige Essen schon vorhanden ist
            neededFood.put(food, neededFood.get(food) + amountOfFood);    // fügt das jeweilige Essen hinzu; erste Value ist der Key; zweite Value was dazu muss
        } else {
            neededFood.put(food, amountOfFood);                           // Fügt das jeweilige Essen hinzu, falls es noch nicht existiert
        }

    }

    public void giveTierEssen(Pfleger pfleger) {
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " füttert " + Colors.COLORS[6] + getName() + Colors.RESET);
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void startFightSimulation(Tier victim) {
        if (rand.nextInt(100) < 60 &&   // 60 % Wahrscheinlichkeit, dass Tier beißen können
                victim.isAlive() &&
                this.isAlive()) {
            if (victim.getName().equals(this.getName())) {
                System.out.println(this + Colors.COLORS[1] + " Kann sich nicht selbst beißen!" + Colors.RESET);
            } else {
                System.out.println(this + " attackiert " + Colors.COLORS[6] + victim.getName() + Colors.RESET);
                victim.setCurrentHP(victim.getCurrentHP() - this.getDamage());
                System.out.println(Colors.COLORS[6] + victim.getName() + Colors.RESET + "'s aktuelles Leben ist " + Colors.COLORS[6] + victim.getCurrentHP() + " HP" + Colors.RESET);
            }
            if (!victim.isAlive()){
                System.out.println(Colors.COLORS[1] + victim.getName()  + " ist gestorben." + Colors.RESET);
            }
        }
    }


    @Override
    public String toString() {
        return Colors.COLORS[6] + name + Colors.RESET;
    }
}