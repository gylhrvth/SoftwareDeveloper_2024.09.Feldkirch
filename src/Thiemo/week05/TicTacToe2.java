package Thiemo.week05;

import Sandro.Colors;
import Thiemo.ConsoleInput;

/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation           !!
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt       !!
*3  Spielfeld ausdrucken                                    !!
*4  Spieler wechseln
*5  UserInput lesen
*6  Feld Belegen
*7  Prüfen ob das Feld leer ist
*8  Win condition prüfen

*/
public class TicTacToe2 {



    public static void main(String[] args) {
        int[][] board = new int[3][3];           //int [][] board = fillboard();
        printBoard(board);

        boolean wincon = false;
        int player = 0;
        int turn = 0;
        while (!wincon && turn < 9) {
            player = nextPlayer(player);
            nextMove(board, player);
            printBoard(board);
            wincon = checkWinner(board, player);
            turn++;
        }
        if (wincon){
            System.out.println("\nPlayer " + player + " wins for");
        } else {
            System.out.print("It's a Draw");
        }
    }

    public static void nextMove(int[][] board, int player){
        boolean validmove = false;
        while (!validmove) {
            System.out.println("Player" + (player == 1 ? " (X) " : " (O) " + " choose your Position"));
            int userInput = ConsoleInput.readNumber(">>>", 1, 9);
            int row = (userInput - 1) / 3;
            int col = (userInput - 1) % 3;

            if (board[row][col] == 0) {
                board[row][col] = player;
                validmove = true;
            } else {
                System.out.print("This position is already used please take a different one");
            }
        }

    }

    public static int nextPlayer(int lastPlayer){
        int player = 1;
        if (lastPlayer == 1) {
            player = 2;
        }
        return player;
    }

    public static void printBoard(int[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.println("---------------");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| ");
                if (board[i][j] == 1) {
                    System.out.print(Colors.COLORS[6] + "X" + Colors.RESET);
                } else if (board[i][j] == 2) {
                    System.out.print(Colors.COLORS[1] + "O" + Colors.RESET);
                } else {
                    System.out.print((i * 3) + j + 1);
                }
                System.out.print(" |");
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