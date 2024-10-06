package Erik.week04;

import Erik.week03.RateSpiel_Edited;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int userInput = 3;
        int[][] testfeld = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        int[][] gameField = new int[3][3];
//        printSpielfeld(gameField);
        int[][] gameField = createGameField(3);
        printField(gameField);
        controlUserInput("Welches Feld soll es sein 1-9?", 1, 9);
        updateField(gameField, userInput);
        printField(gameField);

    }

    public static int[][] createGameField(int size){
        int[][] result = new int[size][size];
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result[i].length ; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }

    public static void printField(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int controlUserInput(String msg, int minValue, int maxValue) {
        int userInput = 0;
        boolean vaildNumber = false;

        while (!vaildNumber) {
            try {
                System.out.println(msg);
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue) {
                    vaildNumber = true;
                } else {
                    System.out.println("Between 1-9!");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error Only Numbers");
            }
            sc.nextLine();
        }
        return userInput;
    }

    public static void updateField(int[][] gameField, int userInput) {
        int row = 0;
        int col = 0;
        // Game Field ist dem Numpad nach empfunden
        if (userInput == 7) {
            row = 0;
            col = 0;
        } else if (userInput == 8) {
            row = 0;
            col = 1;
        } else if (userInput == 9) {
            row = 0;
            col = 2;
        } else if (userInput == 4) {
            row = 1;
            col = 0;
        } else if (userInput == 5) {
            row = 1;
            col = 1;
        } else if (userInput == 6) {
            row = 1;
            col = 2;
        } else if (userInput == 1) {
            row = 2;
            col = 0;
        } else if (userInput == 2) {
            row = 2;
            col = 1;
        } else if (userInput == 3) {
            row = 2;
            col = 2;
        }
        gameField[row][col] = userInput;
    }

    public static void gameLogic(int[][] arr) {
        int count = 0;
        int player = 1;
        int validMove = 0;
        boolean win = false;
        boolean validInteraction = false;

        while (!win && count < 9) {

            while (!validInteraction)
                validMove = controlUserInput("m",1,9);



                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            // Spieler 1 abfrage nach Numpad stellen 1-9 (Scanner)
            // Spieler 1 abfrage, ob das feld noch frei ist (if/else)
            // Spielfeld wird neu geprintet mit dem neuen Wert (Spielfeld print neuer Aufruf)
            // Spieler swap


        }
    }

}
