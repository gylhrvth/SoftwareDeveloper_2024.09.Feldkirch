package Gyula.week12;

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

    public Actor(){
        // TODO: Initialize the Actor
        regieOf = new Vector<>();
        actorOf = new Vector<>();
    }

    public void addFilmAsRegie(Film f){

    }

    public void addFilmAsActor(Film f){

    }
}
