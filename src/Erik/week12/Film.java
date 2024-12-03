package Erik.week12;

import Gyula.WildColors;
import java.util.Vector;

public class Film {

    // Attribute
    private int id;
    private String title;
    private Actor regie;
    private Vector<Actor> actorList;


    // Konstruktor
    public Film(int id, String title) {
        this.id = id;
        this.title = title;
        this.regie = null;
        actorList = new Vector<>();
    }


    // Getter - Setter
    public int getId() {
        return id;
    }


    // Methoden
    public void setRegie(Actor regie) {
        this.regie = regie;
        if (regie != null){
            regie.addFilmAsRegie(this);
        }
    }

    public void addActor(Actor a) {
        if (!actorList.contains(a)){
            actorList.add(a);
            a.addFilmAsActor(this);
        }
    }

    public void printStructure(){
        System.out.println("│   │   ├── Film: " + this + " / Regie: " + regie);
        System.out.println("                  Actors: " + actorList);
    }

    @Override
    public String toString() {
        return WildColors.getColor("#CA66AA") + title + WildColors.resetColor();
    }
}