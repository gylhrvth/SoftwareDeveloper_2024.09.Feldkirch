package Aylin.week12;

import java.util.Vector;

public class Film {
    private int id;
    private String title;
    private Actor regie;
    private Vector<Actor> actorList;

    public Film(int id, String title, Actor regie){
        this.id = id;
        this.title = title;
        this.regie = regie;
        actorList = new Vector<>();
    }

    public void addActor(Actor a){
        if(a != null){
            actorList.add(a);
            System.out.println(a.getFullName() + " was added to the actors List of " + title + ".");
            //a.addFilmAsActor(this);
        }
    }

}
