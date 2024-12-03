package Aylin.week12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        IMDB imdb = new IMDB();

        Actor johansson = new Actor(1, "Scarlett", "Johansson", 40);
        Actor aniston = new Actor(2, "Jennifer", "Aniston", 55);

        Film avengers = new Film(1, "Avengers", aniston);

        DBManager dbManager = DBManager.getInstance();
        dbManager.readAllActorFromDB(imdb);

        imdb.printAll();

        avengers.addActor(johansson);
        dbManager.addActor(johansson);



    }
}
