package Akif_Malik.week12;

import java.util.Vector;

public class Film {
    private int id;
    private String title;
    private Akif_Malik.week12.Actor regie;
    private Vector<Akif_Malik.week12.Actor> actorList;

    public Film(int id, String title) {
        this.id = id;
        this.title = title;

        // TODO: Initialize a film
        regie = null;
        actorList = new Vector<>();
    }

    public void setRegie(Actor a){
        regie = a;
        if (regie != null){
            regie.addFilmAsRegie(this);
        }
    }

    public void addActor(Actor a) {
        if (!actorList.contains(a)) {
            actorList.add(a);

        }
    }

    public void printResult() {

        System.out.printf("Film: %s \n", title);
        System.out.println("Actor:");
        for (Actor ac: actorList) {
            ac.printStructure();
        }
    }
}
