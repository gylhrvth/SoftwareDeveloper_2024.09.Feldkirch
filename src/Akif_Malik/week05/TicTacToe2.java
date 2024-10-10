package Akif_Malik.week05;

import Akif_Malik.week02.UserInput_StringEinlesen;

import java.util.Scanner;

public class TicTacToe2 {
    public static void main(String[] args) {;
        int[][] field = createField();
        printTicTacToe(field);

        int player = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Player " + player + " has the next move!");
            int userChoice = UserInput_StringEinlesen.readNumbers(">>>", "ERROR ERROR ERROR",1, 9);
            player = player == 1 ? 2 : 1;
            printTicTacToe(field);
        }
    }

    public static int[][] createField() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }

    public static void printTicTacToe(int[][] Field) {
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++) {
                System.out.printf("%d ", 3 * i + j + 1);
            }
            System.out.println();
        }
    }


}
