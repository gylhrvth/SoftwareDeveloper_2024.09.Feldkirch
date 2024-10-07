package Thiemo.week04;


import Sandro.Colors;
import Thiemo.ConsoleInput;
/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation           !!
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt       !!
*3  Spielfeld ausdrucken                                    !!
*4  Spieler wechseln                                        !!
*5  UserInput lesen                                         !!
*6  Feld Belegen                                            !!
*7  Prüfen ob das Feld leer ist                             ??
*8  Win condition prüfen                                    ??

*/

public class TicTacToe {


    public static void main(String[] args) {

        int[][] board = new int[3][3];           //int [][] board = fillboard();
        printBoard(board);

        boolean wincon = false;
        int player = 0;
        int turn = 0;
        while (!wincon) {

            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
            boolean validmove = false;
            while (!validmove && turn < 9) {

                System.out.println("Player " + player + (player == 1 ? " (X) " : " (O) " + " choose your Position"));
                int userInput = ConsoleInput.readNumber(">>>", 1, 9);

//        boardPositions(board, userInput, player);

                int row = (userInput - 1) / 3;
                int col = (userInput - 1) % 3;

                if (board[row][col] == 0) {
                    board[row][col] = player;
                    validmove = true;

                } else {
                    System.out.print("This position is already used please take a different one bitch");
                }
                if (checkWinner(board, player)) {
                    printBoard(board);
                    System.out.println("\nPlayer " + player + " wins for");
                    wincon = true;

                }
                printBoard(board);
                if (turn == 8) {
                    System.out.print("It's a Draw G.");
                    wincon = true;
                }
                turn++;
            }
        }
    }

    //    public static int[][] fillboard() {
////        int counter = 0;
//        int[][] result = new int[3][3];
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
////                result[i][j] = counter;
////                counter++;
//            }
//        }
//        return result;
//    }
    public static void printBoard(int[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.println("---------------");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print(Colors.COLORS[6] + "| X |" + Colors.RESET);
                } else if (board[i][j] == 2) {
                    System.out.print(Colors.COLORS[1] + "| O |" + Colors.RESET);
                } else {
                    System.out.print("| ");
                    System.out.print((i * 3) + j + 1);
                    System.out.print(" |");
                }
//                System.out.print((i * 3) + j + 1);        // print from 1 to X         // wrong-
//                System.out.print(board[i][j]);            // print everything as 0     // line?
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static boolean checkWinner(int[][] board, int player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && (board[i][2] == player)) {
                return true;
            }
            if (board[0][i] == player && (board[1][i]) == player && (board[2][i] == player)) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && (board[2][2] == player)) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && (board[2][0] == player);
    }
}


