package Furkan.week09.Person;

public class Human1 {

    private String name;
    private int age;
    private int size;
    private int weight;


    public Human1(String name, int age, int size, int weight) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.weight = weight;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public String toString(){
        return name + "(" + age +" - " + size +" cm/" +weight +"kg";
    }

}
