package Thiemo.week05;

import Gyula.ConsoleTools;

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
    public static void main(String[] args) {

        playTicTacToe();

    }

    public static void printTicTacToe(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1)
                    System.out.print("X ");
                else if (board[i][j] == 2) {
                    System.out.print("O ");
                } else {
                    System.out.printf("%d ", 3 * i + j + 1);
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int player, int[][] board) {
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

    public static boolean checkBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                }
            }
        }
        return true;
    }

    public static void playTicTacToe() {
        int[][] board = new int[3][3];
        int player = 1;

        boolean wincondition = false;

        while (!wincondition && checkBoard(board)) {
            printTicTacToe(board);
            System.out.println("Player " + player + (player == 1 ? " (X) " : " (O) " + "choose"));
            int input = ConsoleTools.readNumber(">>>", 1, 9);
            int row = (input - 1) / 3;
            int col = (input - 1) % 3;

            if (board[row][col] == 0) {
                board[row][col] = player;

                if (checkWin(player, board)) {
                    wincondition = true;
                }
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            } else {
                System.out.println("Position is already taken. Please choose a different position");
            }
        }
    }
}

