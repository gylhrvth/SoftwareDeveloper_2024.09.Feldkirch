package Aylin.week07.home;

public class Human {
    //Attribute
    private String name;
    private int age;
    private int size;
    private int weight;

    //Konstruktor
    public Human(String name, int age, int size, int weight){
        this.name = name;
        this.age = age;
        this.size = size;
        this.weight = weight;
    }

    //Methode
    public void satzFormat(){
        System.out.println("Name: " + name + ", " + age + " Jahre alt, " + size + "cm groß und wiegt " + weight + "kg.");
    }

    @Override
    public String toString() {
        return name;
    }
}
