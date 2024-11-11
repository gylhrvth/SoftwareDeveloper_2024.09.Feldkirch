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

    public int getAge(){
        return age;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.format("| %-20s: %5s - %5s cm / %5s kg |", name, age, height, weight);
    }
}
