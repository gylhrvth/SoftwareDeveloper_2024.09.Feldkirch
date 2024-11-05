package Gyula.week08.Human;

public class Human2 {

    private String name;
    private int age;
    private int height;
    private int weight;

    public Human2(String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + age + " - " + height + " cm/" + weight +"kg)";
    }
}
