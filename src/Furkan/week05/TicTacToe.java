package Furkan.week05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        int[][] field = create2DArray();
        print2DArray(field);
        System.out.println();

        boolean gameon = true;
        int currentPlayer = 1;

        while (gameon) {
            int playerMove = readNumber("Please enter your move (0-8");
        }
        print2DArray(field);


    }

    public static int[][] create2DArray() {
        int[][] result = new int[3][3];
        int counter = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = counter;
                counter++;
            }
        }
        return result;
    }


    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.println("----|-----|----");
            }
            for (int j = 0; j < array.length; j++) {
                if (j > 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int readNumber(String msg) {
        int number = 0;
        boolean NumberisValid = false;

        while (!NumberisValid) {
            try {
                System.out.println(msg);
                number = Integer.parseInt(scanner.nextLine());
                NumberisValid = true;
            } catch (InputMismatchException ime) {
                System.out.println("Sorry, that was not a Valid number");
            }
        }
        return number;
    }

    public static void playerMove(int[][] field, int currentPlayer){
        int playermove =readNumber("Player" + currentPlayer + "please enter your Move");



    }



}

