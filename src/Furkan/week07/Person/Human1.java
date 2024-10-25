package Furkan.week07.Person;

import java.text.NumberFormat;

public class Human1 {
    private String name;
    private int age;
    private int size;
    private int weight;
    private long bounty;
   // private String

    public Human1(String name, int age, int height, int weight, long bounty) {
        this.name = name;
        this.age = age;
        this.size = height;
        this.weight = weight;
        this.bounty = bounty;
    }

    public void printOut() {
        NumberFormat formatter = NumberFormat.getInstance();
        String formattedBounty = formatter.format(bounty);
        System.out.println("Name: " + name + ", " + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg." +
                           " Sein Kopfgeld beträgt " + formattedBounty + " Berry.");
    }

    public String toString(){
        return "Name: " + name + ", " + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg." +
               " Sein Kopfgeld beträgt " + bounty + " Berry.";
    }
}
