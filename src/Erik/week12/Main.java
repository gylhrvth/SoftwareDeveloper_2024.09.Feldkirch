package Erik.week12;

import java.sql.*;

// TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java

public class Main {

    public static void main(String[] args) throws SQLException {

        // Objekt zum Speichern der Daten aus der Datenbank
        IMDB imdb = new IMDB();

        // Braucht Objekt für die Ausführung
        DBManager.getInstance().readActorFromDB(imdb);
        DBManager.getInstance().readMovieFromDB(imdb);

        imdb.printInfos();

        // ToDo: Actoren in Film hinzufügen und Filme in die Actoren hinzufügen.





        DBManager.getInstance().closeConnection();
    }
}