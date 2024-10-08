package Aylin.week05;

import Sandro.Colors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FourInARow {
    public static Scanner sc = new Scanner(System.in);

    public static String player1Color = Gyula.WildColors.getColor(255, 239, 3) + "@" + Colors.RESET;

    public static String player2Color = Gyula.WildColors.getColor(0, 70, 132) + "@" + Colors.RESET;

    public static void main(String[] args) {
        int[][] board = new int[6][7];
        gamePlay(board);
    }

    public static void printField(int[][] arr) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("xx ");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(player1Color + " xx ");
                } else if (arr[i][j] == 2) {
                    System.out.print(player2Color + " xx ");
                } else {
                    System.out.print("  xx ");
                }
            }
            System.out.println();
        }
        System.out.println("---0----1----2----3----4----5----6---");
    }

    public static void gamePlay(int[][] board){
        boolean win = false;
        int counter = 0;
        int player = 1;

        printField(board);

        while(!win && counter < board.length * board[0].length) {
            System.out.print("Player " + player + " make your move. ");
            int row = -1;
            int col = validNumber("Which col would you like to place? ");

            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == 0) {
                    row = i;
                }
            }
            if(row != -1) {
                board[row][col] = player;
                win = rules(board, player);
                printField(board);
                counter++;

                if (!win) {
                    player = (player == 1) ? 2 : 1;
                }
            }else {
                System.out.println("Column is full");
            }
        }
        printGameResult(win, player, counter);
    }

    public static int validNumber(String msc){
        int number = -1;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.print(msc);
                number = sc.nextInt();
                sc.nextLine();
                if (number >= 0 && number < 7) {
                    validNumber = true;
                } else {
                    System.out.println("Input Number must be between 0 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                sc.nextLine();
            }
        }
        return number;
    }

    public static void printGameResult(boolean win, int player, int counter){
        if(win == true){
            System.out.println("Congratulations Player " + player + ". You win!");
        }else if(counter >= 41){
            System.out.println("It's a draw! Try better next time!");
        }
    }

    public static boolean rules(int[][] board, int player) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }else if(board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player){
                    return true;
                }
            }
        }
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player){
                    return true;
                }
            }
        }
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if(board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}