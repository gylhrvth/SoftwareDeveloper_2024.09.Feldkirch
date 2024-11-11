package Sandro.Week8.Person2;

public class Person {
    private String name;
    private int height;
    private int weight;
    private int age;


    public Person(String name, int height, int weight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;

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
        return "Name is: " + name + " - Height is: " + height + " cm" + " - Age is: " + age + " years" + " - Weight is: " + weight + " kg";
    }
}
