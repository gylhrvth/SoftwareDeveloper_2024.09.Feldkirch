package Thiemo.week07.LivingBeing;

import Sandro.Colors;

public class Person {

    //Attribute
    private int height;
    private int age;
    private String name;
    private int weight;

    private static int personCount = 0;
    private int personNumber;

    //Konstruktor
    public Person(int height, int age, String name, int weight) {
        if (height > 250){
            throw new RuntimeException("Invalid height");
        }

        this.height = height;
        this.age = age;
        this.name = name;
        this.weight = weight;

        personCount++;
        this.personNumber = personCount;
    }

    // Getters and Setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //JustforFun BMI Berechnung????
    public double calculateBMI() {
        // Höhe muss in Metern sein, daher durch 100 teilen
        double heightInMeters = height / 100.0;
        // BMI-Formel: Gewicht in kg / (Höhe in Metern)^2
        return weight / (heightInMeters * heightInMeters);
    }

//    // Overriding the toString method for better output representation
//    @Override
//    public String toString() {
//        return "Person " + personNumber + " {" +
//                "Größe = " + height + " cm" +
//                ", Alter = " + age + " Jahre" +
//                ", Name = '" + name + '\'' +
//                ", Gewicht = " + weight + " kg" +
//                '}';
//
//    }

        // Overriding the toString method for better output representation
    @Override
    public String toString() {
        return "Person " + personNumber + " {" +
                " Name = '" + name + '\'' +
                ", Alter = " + age + " Jahre" +
                ", Größe = " + String.format("%s%4d cm%s", Colors.COLORS[2], height, Colors.RESET) +
                ", Gewicht = " + weight + " kg" +
                '}';

    }
}