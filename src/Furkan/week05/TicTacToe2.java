package Furkan.week05;

import Gyula.ConsoleTools;

import java.util.Scanner;

public class TicTacToe2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] field = createField();
        printArray(field);
        //prinField(field);


        int spieler = 1;
        for (int i = 0; i < 9; i++) {
            System.out.println("Spieler" + spieler);

            if (spieler == 1) {
                spieler = 2;

            } else spieler = 1;

            int playerChoiseRow = ConsoleTools.readNumber("Row>>", 0, 2);
            int playerChoiseCol = ConsoleTools.readNumber("Col>>", 0, 2);
            System.out.println("Spieler" + spieler + "move" + playerChoiseRow + ", " + playerChoiseCol);
            if (field[playerChoiseRow][playerChoiseCol]  !=0){
                System.out.println("Dieses Feld ist bereits belegt!");
            }
           field[playerChoiseRow][playerChoiseCol]=spieler;

            printArray(field);


        }




    }

    public static int[][] createField() {
        int[][] result = new int[3][3];
        int counter = 1;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = counter;
                counter++;
            }

        }
        return result;
    }


    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }


}



