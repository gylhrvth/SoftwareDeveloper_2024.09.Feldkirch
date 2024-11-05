package Aylin.Herbstferien.OOP.Human;

public class Human {
    //Attributes
    public String name;
    public String surname;
    public int age;
    public int weight;
    public int height;
    public String gender;

    //Konstruktor
    public Human (String name, String surname, int age, int weight, int height, String gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public String toString() {
        return "Name: " + name + " " + surname + " (" + gender + "), " + age + " years old, " + height + "cm heigh and " + weight + "kg.";
    }
}
