package Thiemo.week12;

import java.util.Vector;

public class IMBD {
    private final Vector<Film> filmlist;

    public IMBD() {
        filmlist = new Vector<>();
    }

    public void addFilm(Film film) {
        if (!filmlist.contains(film)) {
            filmlist.add(film);
        }
    }

}


