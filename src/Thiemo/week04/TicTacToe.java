package Thiemo.week04;

import Sandro.Colors;

import java.util.Scanner;
/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt
*3  Spielfeld ausdrucken
*4  Spieler wechseln
*5  UserInput lesen
*6  Feld Belegen
*7  Prüfen ob das Feld leer ist
*8  Win condition prüfen

*/
public class TicTacToe {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] board = create2DArray();
        print2Darray(board);
        int turn = 0;
        boolean gameloop = true;

        while (gameloop) {

            int player;
            if (turn % 2 == 0) {
                player = 1;
            } else {
                player = 2;
            }
            int userInput = readNumber("Player " + player + " choose a position", 1, 9);
            boolean validMove = FieldPositions(board, userInput, player);
            boolean validTurn = true;

            if (!validMove) {
                System.out.println("This spot is already taken! Try again.");
                validTurn = false;
            }

            if (validTurn) {
                print2Darray(board);
                if (checkWin(board, player)) {
                    System.out.println("Player " + player + " Wins");
                    gameloop = false;
                } else if (turn == 8) {
                    System.out.println("It's a Draw");
                    gameloop = false;
                }
            }
            turn++;
        }
        System.out.println("Thanks for wasting your time");
    }

    public static int[][] create2DArray() {

        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }

    public static void print2Darray(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.println("-----|-------|-----");
            }

            for (int j = 0; j < array[0].length; j++) {
                if (j > 0) {
                    System.out.print("  |  ");
                }
                if (array[i][j] == 1) {
                    System.out.print(Colors.COLORS[4] + " X " + Colors.RESET);
                } else if (array[i][j] == 2) {
                    System.out.print(Colors.COLORS[2] + " O " + Colors.RESET);
                } else {
                    System.out.print(" " + ((i * 3) + j + 1) + " ");               // 1-9
//                    System.out.print(" " + array[i][j] + " ");                   // everything is 0
                }
            }
            System.out.println();
        }
    }

    public static int readNumber(String userinfo, int minValue, int maxValue) {
        int number = 0;
        boolean correctInput = false;

        while (!correctInput) {
            try {
                System.out.println(userinfo);
                number = Integer.parseInt(sc.nextLine());
                if (number >= minValue && number <= maxValue) {
                    correctInput = true;
                } else {
                    System.out.println("The number should be between " + minValue + " and " + maxValue + "\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error! Please try a valid number.\n");
            }
        }
        return number;
    }

    public static boolean FieldPositions(int[][] board, int input, int player) {

        int row = (input - 1) / 3;
        int col = (input - 1) % 3;

        if (board[row][col] == 0) {
            board[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkWin(int[][] board, int player) {

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
