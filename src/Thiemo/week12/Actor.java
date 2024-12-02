package Thiemo.week12;

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



    public Actor(int id, String firstName, String lastName, int age, int height, int weight){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        // TODO: Initialize the Actor
        regieOf = new Vector<>();
        actorOf = new Vector<>();
    }
public int getId(){return id;}

    public void addFilmAsRegie(Film f){
if (!regieOf.contains(f)){
    regieOf.add(f);
}
    }

    public void addFilmAsActor(Film f){
        if (!actorOf.contains(f)){
            actorOf.add(f);
        }
    }
    public void printStructure(){
            System.out.printf("    %s resonsible for: ", this);
            for (int i = 0; i < regieOf.size(); i++) {
                if (i > 0){
                    System.out.print(", ");
                }
                System.out.print(regieOf.get(i));
            }
            System.out.println();
        }
    }

