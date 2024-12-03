package Erik.week12;

import java.util.Vector;

public class IMDB {

    // Attribute
    private Vector<Film> filmList;
    private Vector<Actor> actorList;


    // Konstruktor
    public IMDB() {
        filmList = new Vector<>();
        actorList = new Vector<>();
    }


    // Methoden
    public void addFilm(Film f) {
        if (!filmList.contains(f)) {
            filmList.add(f);
        }
    }

    public void addActor(Actor a) {
        if (!actorList.contains(a)) {
            actorList.add(a);
        }
    }

    public void printInfos() {

        System.out.println("│   ├── All Actors: ");
        for (Actor a : actorList) {
            a.printStructure();
        }

        System.out.println("│   ├── All Movies: ");
        for (Film f : filmList){
            f.printStructure();
        }
    }
}