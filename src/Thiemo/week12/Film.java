package Thiemo.week12;

import java.util.Vector;

public class Film {
    private int id;
    private String title;
    private Actor regie;
    private Vector<Actor> actorList;

    public Film(int id, String title) {
        this.id = id;
        this.title = title;

        // TODO: Initialize a film
        actorList = new Vector<>();
    }

    public void addActor(Actor a) {
        if (!actorList.contains(a)) {
            actorList.add(a);

        }
    }

    public void printResult() {

        System.out.printf("Film: %s \n", title);
        System.out.println("Actor:");
        for (Actor ac : actorList) {
            ac.printStructure();
        }
    }
}