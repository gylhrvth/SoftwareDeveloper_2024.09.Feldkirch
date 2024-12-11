package Thiemo.week12;


import java.sql.*;

public class Main {
    public static void main(String[] args) {
        IMDB imdb = new IMDB();

        DBManager dbManager = DBManager.getInstance();

        dbManager.readFromDatabaseActor(imdb);
        dbManager.readFromDatabaseFilm(imdb);
        dbManager.readAllFilmActorsFromDB(imdb);


        imdb.printAll();
        imdb.getFilmByID(4).setTitle("");
        System.out.println();
    }
}
