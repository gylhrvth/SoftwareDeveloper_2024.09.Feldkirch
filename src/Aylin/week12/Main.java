package Aylin.week12;

import java.util.Scanner;

public class Main {
    public Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        IMDB imdb = new IMDB();

        DBManager dbManager = DBManager.getInstance();
        dbManager.readAllActorFromDB(imdb);
        dbManager.readAllFilmsFromDB(imdb);
        dbManager.readAllFilmActorsFromDB(imdb);

        imdb.printAll();
        imdb.getFilmByID(4).setTitle("Friends");
    }
}
