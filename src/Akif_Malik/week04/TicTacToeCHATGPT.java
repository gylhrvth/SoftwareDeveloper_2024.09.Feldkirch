package Akif_Malik.week04;

import java.util.Scanner;

public class TicTacToeCHATGPT {

    public static class TicTacToe {
        private char[][] board;
        private char currentPlayer;

        public TicTacToe() {
            board = new char[3][3];
            currentPlayer = 'X'; // Starting player
            initializeBoard();
        }

        public void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
        }

        public void printBoard() {
            System.out.println("Current board:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean checkForWin() {
            // Check rows, columns, and diagonals
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                    return true;
                }
                if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                    return true;
                }
            }
            if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
                return true;
            }
            if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                return true;
            }
            return false;
        }

        public void changePlayer() {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        public boolean placeMark(int row, int col) {
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            TicTacToe game = new TicTacToe();
            Scanner scanner = new Scanner(System.in);
            boolean gameEnded = false;

            while (!gameEnded) {
                game.printBoard();
                System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.placeMark(row, col)) {
                    if (game.checkForWin()) {
                        game.printBoard();
                        System.out.println("Player " + game.currentPlayer + " wins!");
                        gameEnded = true;
                    } else if (game.isBoardFull()) {
                        game.printBoard();
                        System.out.println("The game is a tie!");
                        gameEnded = true;
                    } else {
                        game.changePlayer();
                    }
                } else {
                    System.out.println("This move is not valid");
                }
            }
            scanner.close();
        }
    }

}
