package Gyula.week03;

import Gyula.week02.Rhombus;

import java.util.Scanner;

public class MenuExample {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Willkommen bei meinen Aufgaben!\n" +
                "Was möchten Sie zeichnen?\n" +
                "1) Christbaum\n" +
                "2) Quader\n" +
                "3) Rhombus");

        int menuChoice = GuessTheNumberVol2VonAylin.readNumber("Bitte wählen Sie nun?", 1, 3);
        if (menuChoice == 1){
            menuChristbaum();
        } else if (menuChoice == 2){
            menuQuader();
        } else {
            menuRhombus();
        }
    }

    public static void menuChristbaum(){
        int size = GuessTheNumberVol2VonAylin.readNumber("Wie groß soll der Baum sein? ", 3, 54);
        Aylin.week01.PrintChristmastree.printChristmastree(size);
    }

    public static void menuQuader(){
        int size = GuessTheNumberVol2VonAylin.readNumber("Wie groß soll der leere Quader sein? ", 1, 10);
        String character = readText("Welches Zeichen soll ich anwenden? ");
        Aylin.week01.Square.printEmptySquare(character + " ", size);
    }

    public static void menuRhombus(){
        int size = GuessTheNumberVol2VonAylin.readNumber("Wie groß soll der Rhombus sein? ", 1, 10);
        String character = readText("Welches Zeichen soll ich anwenden? ");
        Aylin.week01.Rhombus.printRhombus(character, size);
    }

    public static String readText(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
