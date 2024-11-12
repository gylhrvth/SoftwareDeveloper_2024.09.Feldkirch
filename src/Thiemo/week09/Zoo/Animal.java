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
    private int SP;
    private Food food;
    private double amount;


    public Animal(String genus, String name, String gender, String agegroup, int dangerLevel, int HP, int SP, Food food, double amount) {
        this.name = name;
        this.genus = genus;
        this.gender = gender;
        this.agegroup = agegroup;
        this.dangerLevel = dangerLevel;
        this.HP = HP;
        this.SP = SP;
        this.food = food;
        this.amount = amount;
    }

    public void printAnimal() {
        System.out.println("│   │   ├── " + Colors.COLORS[1]+genus +Colors.RESET+ " " + name + ", " + gender + ", " + agegroup + ", Dangerlvl:" + dangerLevel + " HP:" + HP + " SP:" + SP);
    }

    public void collectFood(HashMap<Food,Double>foodrequiert){
        if (foodrequiert.containsKey(food)){
            foodrequiert.put(food,foodrequiert.get(food)+ amount);
        } else {
            foodrequiert.put(food,amount);
        }
    }
    public void simulateDayAnimal(int day){
        System.out.println("Animal "+ name + " attacks ");

    }
    public void simulateDayAnimalfeeding(){
        if (random.nextInt(100) < 10){
//            this.HP = (HP -10);
            System.out.println(Objects.requireNonNull("==>" +Colors.COLORS[1] + name + " didnt get food and is fucking angry" + Colors.RESET));
//            System.out.println(name + HP + "HP");
        }else {
            System.out.println("==>" +Colors.COLORS[6] + name + " got fed and chills now" + Colors.RESET);
        }
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

