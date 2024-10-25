package Akif_Malik.week07.Human;

import Sandro.Colors;

public class Person {
    //Atribute

    private String firstName;

    private String surName;

    private String fullName;

    private int age;

    private String gender;

    private int height;

    private int weight;

    //Konstruktor

    public Person(String firstName, String surName, int age, String gender, int height, int weight) {
        this.firstName = firstName;
        this.surName = surName;
        this.fullName = firstName + " " + surName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;

    }

    //Funktionen

    public String getFullName() {
        return fullName;
    }

    public String getSurName() {
        return surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    //Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //----------------------------------------------------------------------------------------\\

    @Override
    public String toString() {
        return firstName + " " + surName + "\nAge: " + age + "\nGender: " + gender;
    }
}
