package Furkan.week07.Person;

import java.text.NumberFormat;

public class Human1 {
    private String firstName;
    private String surName;

    private String fullName;
    private int age;
    private int size;
    private int weight;
    private long bounty;
   // private String


    public Human1(String firstName, String surName, String fullName,
                  int age, int weight,int size,long bounty ) {
        this.firstName = firstName;
        this.surName = surName;

        this.fullName = firstName+ " " + surName;
        this.age = age;
        this.weight = weight;
        this.bounty = bounty;
        this.size = size;
    }

    public void createFullName(){
        this.fullName = firstName + " "+surName;
    }
    public String getFullName(){
        return fullName;
    }

    public String getName() {
        return fullName;
    }

    public void printOut() {
        NumberFormat formatter = NumberFormat.getInstance();
        String formattedBounty = formatter.format(bounty);
        System.out.println("Fullname: " + firstName + " " + surName + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg." +
                           " Sein Kopfgeld beträgt " + formattedBounty + " Berry.");
    }

    public String toString(){
        return "Fullname: " + firstName + " " +surName + age + "Jahre alt, " + size + "cm groß und wiegt " + weight + "kg." +
               " Sein Kopfgeld beträgt " + bounty + " Berry.";
    }
}
