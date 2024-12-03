package Erik.week12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void addActorsToMovie() throws SQLException {
       Connection conn = DBManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from filmactor");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int actorId = rs.getInt("actorid");
            int filmId = rs.getInt("filmid");

            Actor actor = getActorByID(actorId);
            Film film = getFilmByID(filmId);

            if (actor != null && film != null) {
                actor.addFilmAsRegie(film);
                film.addActor(actor);
            }
        }

        rs.close();
        ps.close();
        DBManager.getInstance().closeConnection();
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