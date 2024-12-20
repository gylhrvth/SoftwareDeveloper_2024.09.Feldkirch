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


    public Actor getActorByID(int id){
        for (Actor actor : actorList){
            if (actor.getId() == id){
                return actor;
            }
        }
        return null;
    }

    public Film getFilmByID(int id){
        for (Film film : filmList){
            if (film.getId() == id){
                return film;
            }
        }
        return null;
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