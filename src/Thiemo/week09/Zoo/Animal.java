package Thiemo.week09.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Animal {
    private static Random random = new Random();
    private String name;
    private String genus;
    private String gender;
    private String agegroup;
    private int dangerLevel;
    private int HP;
    private int MaxHP;
    private int SP;
    private Food food;
    private double amount;


    public Animal(String genus, String name, String gender, String agegroup, int dangerLevel, int HP, int MaxHP, int SP, Food food, double amount) {
        this.name = name;
        this.genus = genus;
        this.gender = gender;
        this.agegroup = agegroup;
        this.dangerLevel = dangerLevel;
        this.HP = HP;
        this.MaxHP = MaxHP;
        this.SP = SP;
        this.food = food;
        this.amount = amount;
    }

    public void printAnimal() {
        System.out.println("│   │   ├── " + Colors.COLORS[1] + genus + Colors.RESET + " " + name + ", " + gender + ", " + agegroup + ", Dangerlvl:" + dangerLevel + " HP:" + HP + " SP:" + SP);
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Animal.random = random;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public void collectFood(HashMap<Food, Double> foodrequiert) {
        if (foodrequiert.containsKey(food)) {
            foodrequiert.put(food, foodrequiert.get(food) + amount);
        } else {
            foodrequiert.put(food, amount);
        }
    }

    public boolean isAlive() {
        return HP > 0;
    }


    public void simulatefights(Animal animal, Animal randomanimal) {
        randomanimal.HP = randomanimal.HP - animal.SP;
        if (randomanimal.HP <= 0) {
            System.out.println(randomanimal.getName() + " died");
        } else {
            System.out.println(randomanimal.getName() + " looses " + animal.SP + " HP :" + randomanimal.HP + "/" + randomanimal.MaxHP + "HP");
        }
    }


    public void simulateDayAnimalfeeding() {
        if (random.nextInt(100) < 10) {
//            this.HP = HP - 10;
            System.out.println(("==>" + Colors.COLORS[1] + name + " didnt get food and is angry" + Colors.RESET));
            System.out.println(name + " " + HP + "/" + MaxHP + "HP");
        } else {
            System.out.println("==>" + Colors.COLORS[6] + name + " got fed and chills now" + Colors.RESET);
        }
    }

    public String getGenus() {
        return genus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dangerLevel=" + dangerLevel +
                ", HP=" + HP +
                ", Stamina=" + SP +
                '}';
    }
}

