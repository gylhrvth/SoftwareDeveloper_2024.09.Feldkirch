package Thiemo.week12;

import java.util.Vector;

public class IMDB {
    private final Vector<Film> filmlist;
    private Vector<Actor> actorList;

    public IMDB() {
        filmlist = new Vector<>();
        actorList = new Vector<>();
    }

    public void addFilm(Film film) {
        if (!filmlist.contains(film)) {
            filmlist.add(film);
        }
    }


    public void addActor(Actor actor){
        if (!actorList.contains(actor)){
            actorList.add(actor);
        }
    }

    public Actor getActorByID(int id){
        for (Actor a : actorList){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }
}

