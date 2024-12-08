package Thiemo.week12;

import Aylin.week12.DBManager;

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
        regie = null;
        actorList = new Vector<>();
    }

    public void setRegie(Actor a) {
        regie = a;
        if (regie != null) {
            regie.addFilmAsRegie(this);
        }
    }

    public void addActor(Actor a) {
        if (!actorList.contains(a)) {
            actorList.add(a);
            System.out.println(a.getFirstName() + "was added to the actors of" + title);
        }
    }

    public void setTitle(String title) {
        this.title = title;
        Thiemo.week12.DBManager.getInstance().updateFilm(this);
    }

    public String getTitle() {
        return title;
    }

    public Actor getRegie() {
        return regie;
    }

    public int getId() {
        return id;
    }

    public void printAll(){
        System.out.println("    " + this + " (regie: " + regie + ")");
    }

    public void printResult() {

        System.out.printf("Film: %s \n", title);
        System.out.println("Actor:");
        for (Actor ac : actorList) {
            ac.printStructure();
        }
        System.out.println();
    }
}
