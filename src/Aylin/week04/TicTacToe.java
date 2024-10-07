package Aylin.week04;

import Sandro.Colors;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);

    public static String aylinGreen = Gyula.WildColors.getColor(128, 155, 68);

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        gameLogic(board);
    }

    public static void printField(int[][] arr) {
        System.out.println("        0   1   2");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Row " + i + " |");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(" " + Gyula.WildColors.getColor(255, 239, 3) + arr[i][j] + Colors.RESET + " ");
                } else if (arr[i][j] == 2) {
                    System.out.print(" " + Gyula.WildColors.getColor(0, 70, 132) + arr[i][j] + Colors.RESET + " ");
                } else {
                    System.out.print(" " + arr[i][j] + " ");
                }
                if (j < arr[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public static void gameLogic(int[][] board) {
        boolean win = false;
        int counter = 0;
        int player = 1;

        System.out.println("Player which row and col would you like to place your mark? ");

        while (!win && counter < 9) {
            printField(board);
            int row = getValidInput("Enter row: ");
            int col = getValidInput("Enter col: ");
            if (board[row][col] != 0) {
                System.out.println("Field already taken. Please choose another Field.");
                continue;
            }
            board[row][col] = player;
            counter++;
            win = false;
            if (rules(board, player)) {
                printField(board);
                win = true;
            }
            win = checkGameStatus(board, player, win, counter);
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
    }

    public static int getValidInput(String message) {
        int number = -1;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.print(message);
                number = sc.nextInt();
                if (number >= 0 && number < 3) {
                    validNumber = true;
                } else {
                    System.out.println("Input Number must be between 0 and 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                sc.next();
            }
        }
        return number;
    }

    public static boolean checkGameStatus(int[][] board, int player, boolean win, int counter){
        if (win) {
            System.out.println(aylinGreen + "Congratulations, Player " + player + " wins!!!" + Colors.RESET);
        } else if(counter == 9) {
            printField(board);
            System.out.println(aylinGreen + "It's a draw. Do better next time!" + Colors.RESET);
        }
        return win;
    }

    public static boolean rules(int[][] board, int player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        } else {
            return false;
        }
    }
}