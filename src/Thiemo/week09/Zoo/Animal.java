package Thiemo.week09.Zoo;

import Sandro.Colors;

public class Animal {
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

