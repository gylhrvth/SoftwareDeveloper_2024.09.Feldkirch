package Thiemo.week05;

import Sandro.Colors;

import java.util.Scanner;

/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation       ??
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt   !!
*3  Spielfeld ausdrucken                                !!
*4  Spieler wechseln
*5  UserInput lesen                                     !!
*6  Feld Belegen
*7  Prüfen ob das Feld leer ist
*8  Win condition prüfen

*/

public class TicTacToe1 {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        TicTacToe();

    }

    public static void TicTacToe() {
        System.out.println("\nHello\n");

        int[][] board = new int[3][3];
        printboard(board);
        int turn = 0;

        boolean gameloop = true;

        while (gameloop) {

            int player;                         // swap between players
            if (turn % 2 == 0) {
                player = 1;
            } else {
                player = 2;
            }
            int userInput = readNumber("\nPlayer " + player + " choose a free number on the board", 1, 9);
            boolean validMove = boardpositions(board, userInput, player);
            boolean validTurn = true;

            if (!validMove) {
                System.out.println("This spot is already taken! Try again.");
                validTurn = false;
            }

            if (validTurn) {
                printboard(board);
                if (checkWin(board, player)) {
                    System.out.println("\nPlayer " + player + " Wins");
                    gameloop = false;
                } else if (turn == 8) {
                    System.out.println("\nIt's a Draw");
                    gameloop = false;
                }
            }
            turn++;
        }
        System.out.println("\nGood Game?");
    }

    public static void printboard(int[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print(Colors.COLORS[4] + " X " + Colors.RESET);
                } else if (board[i][j] == 2) {
                    System.out.print(Colors.COLORS[2] + " O " + Colors.RESET);
                } else {
//                System.out.print(" " + board[i][j] + " ");                // prints board with 0
                    System.out.print(" " + ((i * 3) + j + 1) + " ");        // prints board from 1 to X
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

    public static boolean boardpositions(int[][] board, int input, int player) {

        int row = (input - 1) / 3;
        int col = (input - 1) % 3;

        if (board[row][col] == 0) {
            board[row][col] = player;
            return true;
        } else {
            System.out.print("The positions is already taken");
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
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

}


