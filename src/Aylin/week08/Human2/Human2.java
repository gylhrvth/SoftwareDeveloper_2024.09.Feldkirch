package Aylin.week08.Human2;

public class Human2 {

    private String name;
    private int age;
    private int height;
    private int weight;

    public Human2 (String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", height: " + height + " cm, weight: " + weight + " kg.";
    }
}
