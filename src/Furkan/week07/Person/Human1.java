package Furkan.week07.Person;

public class Human1 {
    private String name;
    private int age;
    private int size;
    private int weight;

    public Human1(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.size = height;
        this.weight = weight;
    }

    public void printOut() {
        System.out.println("Name: " + name + ", " + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg.");
    }

    public String toString(){
        return "Name: " + name + ", " + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg.";
    }
}
