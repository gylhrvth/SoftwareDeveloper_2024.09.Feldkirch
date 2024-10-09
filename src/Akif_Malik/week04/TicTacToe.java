package Akif_Malik.week04;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);
    public static String PlayerOne;
    public static String PlayerTwo;

    public static void main(String[] args) {
        createBoard();
        GameMechanics();
    }

    public static int[][] createBoard() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("0 ");
            }
            System.out.println();
        }
        return array;
    }

    public static void GameMechanics() {
        boolean winCondition = false;
        Scanner scanner = new Scanner(System.in);
            String playerOne = userInputReader("Player One, please enter a number between 1 and 9");
            createBoard();
            String playerTwo = userInputReader("Player Two, please enter a number between 1 and 9");
            createBoard();
    }

    public static String userInputReader(String userinfo) {
        System.out.println(userinfo);
        return scanner.nextLine();
    }

    public static void winConditions(int row, int col) {
        boolean condition = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row == i++) {
                    condition = true;
                    System.out.println("Congratulations you've won");
                }
                if (col == j++) {
                    condition = true;
                    System.out.println("Congratulations you've won");
                }
            }
        }
    }
}
