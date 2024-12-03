package Akif_Malik.week12;

import java.util.Vector;

public class IMDB {
    private Vector<Actor> actorlist;
    private Vector<Film> filmList;

    public IMDB() {
        filmList = new Vector<>();
        actorlist = new Vector<>();
    }

    public void addFilm(Film film) {
        if (!filmList.contains(film)) {
            filmList.add(film);
        }
    }

    public void addActor(Actor actor) {
        if (!actorlist.contains(actor)) {
            actorlist.add(actor);
        }
    }

    public Actor getActorbyId(int id) {
        for (Actor a : actorlist) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}
