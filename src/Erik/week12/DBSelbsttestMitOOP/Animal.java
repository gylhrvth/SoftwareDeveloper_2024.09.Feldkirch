package Erik.week12.DBSelbsttestMitOOP;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Animal {
    public static Random rand = new Random();

    // Attribute
    private String name;
    private String gattung;
    private Vector<Food> foodList;
    private Food food;
    private int amountOfFood;
    private int currentHP;
    private int maxHP;
    private int damage;


    // Konstruktor
    public Animal(String gattung, String name, Food food, int amountOfFood, int maxHP, int damage) {
        this.gattung = gattung;
        this.name = name;
        this.food = food;
        this.amountOfFood = amountOfFood;
        this.foodList = new Vector<>();
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

    public int getMaxHP() {
        return maxHP;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }


    // Methoden
    public void printTierStructure() {
        System.out.printf("│   │   ├── Tier:  %-10s │ %-10s │ %-15s │ %3d │\n", name, gattung, food.getName(), amountOfFood);
    }

    public void getEveryFood(HashMap<Food, Integer> neededFood) {

        if (neededFood.containsKey(food)) {                               // Prüft, ob das jeweilige Essen schon vorhanden ist
            neededFood.put(food, neededFood.get(food) + amountOfFood);    // fügt das jeweilige Essen hinzu; erste Value ist der Key; zweite Value was dazu muss
        } else {
            neededFood.put(food, amountOfFood);                           // Fügt das jeweilige Essen hinzu, falls es noch nicht existiert
        }

    }

    public void giveTierEssen(ZooKeeper pfleger) {
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " füttert " + Colors.COLORS[6] + getName() + Colors.RESET);
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void startFightSimulation(Animal victim) {
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
            if (!victim.isAlive()) {
                System.out.println(Colors.COLORS[1] + victim.getName() + " ist gestorben." + Colors.RESET);
            }
        }
    }


    // Bei der Suche nach dem Tier mit dem geringsten HP Wert geht es um die Relative HP nicht um die Current HP
    public float getRelativeHealth() {
        return (this.maxHP * this.currentHP) / 100f;
    }

    public void heal(Vet vet) {
        int procentHeal = rand.nextInt(30, 100); //Zufällig zwischen 30 und 100 %

        int healTest = (maxHP * procentHeal) / 100;
        // procentHeal mit heal verknüpfen
        // anstatt heal = 5
        // heal = prozent wahrscheinlichkeits Heal auf, die aktuelle Leben in Prozent addieren
        // mit getRelativeHealth arbeiten

        if (currentHP < maxHP) {
            System.out.println(this + "'s Current Health is >> (" + currentHP + "/" + maxHP + ")");
            System.out.println(vet.getName() + " starts healing " + this);
            currentHP += healTest;

            if (currentHP > maxHP) {
                setCurrentHP(maxHP);
            }
        }
        System.out.println(this + " got healed +" + healTest + " HP " + "from " + vet.getName());
        System.out.println(this + "'s HP got restored to Max Health");
        System.out.println(this + "'s Current Health after healing is: >> (" + currentHP + "/" + maxHP + ")");


        System.out.println("-".repeat(80));

                //Orginal Funkt

        int heal = 5; // für Test zwecke "15"

        if (currentHP < maxHP) {
            System.out.println(this + "'s Current Health is >> (" + currentHP + "/" + maxHP + ")");
            System.out.println(vet.getName() + " starts healing " + this);
            currentHP += heal;

            if (currentHP > maxHP) {
                setCurrentHP(maxHP);
            }
        }
        System.out.println(this + " got healed +" + heal + " HP " + "from " + vet.getName());
        System.out.println(this + "'s HP got restored to Max Health");
        System.out.println(this + "'s Current Health after healing is: >> (" + currentHP + "/" + maxHP + ")");


    }

    @Override
    public String toString() {
        return Colors.COLORS[6] + name + Colors.RESET;
    }

    public String getFoodByName(){
        for (Food food : foodList){
            return food.getName();
        }
        return null;
    }
}