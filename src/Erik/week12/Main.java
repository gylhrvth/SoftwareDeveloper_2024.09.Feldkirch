package Erik.week12;

import java.sql.*;

// ToDo: Actoren in Film hinzufügen und Filme in die Actoren hinzufügen.

public class Main {
    public static void main(String[] args) throws SQLException {

        // Objekt zum Speichern der Daten aus der Datenbank
        IMDB imdb = new IMDB();
        DBManager dbManager = DBManager.getInstance();
        // Braucht Objekt für die Ausführung
        dbManager.readActorFromDB(imdb);
        dbManager.readMovieFromDB(imdb);
        dbManager.addActorsToMovie(imdb);


        imdb.printInfos();


        dbManager.closeConnection();
    }
}