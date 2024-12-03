package Erik.week12;

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


    // Methoden
    public void addActor(Actor a) {
        if (!actorList.contains(a)){
            actorList.add(a);
        }
    }

    public void printStructure(){
        System.out.println("│   ├── Film: " + title + " / Regie: " + regie.getName());
        for (Actor a : actorList){
            a.printStructure();
        }
    }

}
