package Aylin.week12;

import Gyula.WildColors;

import java.util.Vector;

public class Actor {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;

    private Vector<Film> regieOf;
    private Vector<Film> actorOf;

    public Actor(int id, String firstName, String lastName, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        regieOf = new Vector<>();
        actorOf = new Vector<>();
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void addFilmAsRegie(Film f){
        if (!regieOf.contains(f)){
            regieOf.add(f);
            System.out.println(firstName + " " + lastName + " was added as Regie to the movie " + f + ".");
        }
    }

    public void addFilmAsActor(Film f){
        if (!actorOf.contains(f)){
            actorOf.add(f);
            System.out.println(firstName + " " + lastName + " was added as an Actor to the movie " + f + ".");
        }
    }

    public void printAll(){
        System.out.println("    " + this);
    }

    @Override
    public String toString() {
        return WildColors.getColor("#FF8800") + lastName + ", " + firstName + WildColors.resetColor();
    }
}
