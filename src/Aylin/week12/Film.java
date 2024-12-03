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
        if (regie != null){
            regie.addFilmAsRegie(this);
        }
        actorList = new Vector<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Actor getRegie() {
        return regie;
    }

    public void addActor(Actor a){
        if(a != null && !actorList.contains(a)){
            actorList.add(a);
            a.addFilmAsActor(this);
            System.out.println(a.getFullName() + " was added to the actors List of " + title + ".");
        }
    }

    public void setTitle(String title) {
        this.title = title;
        DBManager.getInstance().updateFilm(this);
    }

    public void printAll(){
        System.out.println("    " + this + " (regie: " + regie + ")");
    }

    @Override
    public String toString() {
        return title;
    }
}
