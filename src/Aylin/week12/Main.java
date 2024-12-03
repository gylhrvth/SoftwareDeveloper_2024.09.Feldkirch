package Aylin.week12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        IMDB imdb = new IMDB();

        DBManager dbManager = DBManager.getInstance();
        dbManager.readAllActorFromDB(imdb);
        dbManager.readAllFilmsFromDB(imdb);

        imdb.printAll();
    }
}
