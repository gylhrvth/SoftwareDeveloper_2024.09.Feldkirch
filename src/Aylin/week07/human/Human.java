package Aylin.week07.human;

import Sandro.Colors;

public class Human {
    //Attribute
    private String name;
    private String surname;
    private int age;
    private int size;
    private int weight;
    private String fullname;

    //Konstruktor
    public Human(String name, String surname, int age, int size){
        this.name = Colors.COLORS[4] + name + Colors.RESET;
        this.surname = surname;
        this.age = age;
        this.size = size;
        this.weight = weight;
        this.fullname = name + " " + surname;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " + age + " Jahre alt, " + size + "cm groß und wiegt " + weight + "kg.";
    }
}
