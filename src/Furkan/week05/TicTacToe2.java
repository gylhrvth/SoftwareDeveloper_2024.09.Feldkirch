package Furkan.week05;

import Gyula.ConsoleTools;
import Sandro.Colors;

import java.util.Scanner;

/*
1: Wie spiechere ich meine Daten? Repräsentation
2: Spielfeld initialisieren. int[3] [3]
3: Spielfeld ausdrucken
4: Spieler wechseln logik
5: User Input lesen
6: Stein legen
7: Prüfung ob das Feld leer ist
8: Win Condition prüfen
 */


public class TicTacToe2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] field = createField();
        printField(field);


        int spieler = 1;

        boolean win = false;

        int turn = 0;
        while (turn < 9 && !win) {
            System.out.println("Spieler" + spieler);

            int playerChoiseRow = ConsoleTools.readNumber("Row>> 0-2", 0, 2);
            int playerChoiseCol = ConsoleTools.readNumber("Col>> 0-2", 0, 2);


            if (field[playerChoiseRow][playerChoiseCol] != 0) {
                System.out.println("Dieses Feld ist bereits belegt!");
            } else {
                field[playerChoiseRow][playerChoiseCol] = spieler;
                System.out.println("Spieler " + spieler + " move" + playerChoiseRow + ", " + playerChoiseCol);
                win = winCheck(spieler, field);
                if (!win) {
                    spieler = (spieler == 1) ? 2 : 1;
                }
                ++turn;
            }
            printField(field);
        }
        if (win) {
            System.out.println("Spieler " + spieler + " hat gewonnen!");
        } else {
            System.out.println("Das Spiel endet Unentschieden!");
        }


    }

    public static int[][] createField() {
        int[][] result = new int[3][3];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = 0;
            }

        }
        return result;
    }

    public static void printField(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    System.out.print(Colors.COLORS[4] + "X " + Colors.RESET);
                } else if (array[i][j] == 2) {
                    System.out.print(Colors.COLORS[2] + "O " + Colors.RESET);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static boolean winCheck(int spieler, int[][] field) {
        if (field[0][0] == spieler && field[0][1] == spieler && field[0][2] == spieler) {
            return true;

        }
        if (field[1][0] == spieler && field[1][1] == spieler && field[1][2] == spieler) {
            return true;

        }
        if (field[2][0] == spieler && field[2][1] == spieler && field[2][2] == spieler) {
            return true;

        }
        if (field[0][0] == spieler && field[1][0] == spieler && field[2][0] == spieler) {
            return true;

        }
        if (field[0][1] == spieler && field[1][1] == spieler && field[2][1] == spieler) {
            return true;

        }
        if (field[0][2] == spieler && field[1][2] == spieler && field[2][2] == spieler) {
            return true;

        }
        if ((field[0][0] == spieler && field[1][1] == spieler && field[2][2] == spieler)) {
            return true;

        }
        if (field[0][2] == spieler && field[1][1] == spieler && field[2][0] == spieler) {
            return true;

        }
        return false;
    }
}

