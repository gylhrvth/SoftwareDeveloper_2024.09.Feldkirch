package Thiemo.week04;

import java.util.Scanner;

public class TicTacToe {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println();
        int[][] playfield = create2DArray();
        print2Darray(playfield);


        System.out.println();
//        int[][] testfeld = {
//
//                {2, 2, 1},
//                {1, 2, 1},
//                {1, 2, 2},
//        };
//        print2Darray(testfeld);

        boolean gameloop = true;
        while (gameloop) {

            int userInputPlayer1 = readNumber("Player 1 choose a position", 1, 9);
            int player1 = 0;
            FieldPositions(playfield, userInputPlayer1, player1);
            print2Darray(playfield);
            int userInputPlayer2 = readNumber("Player 2 choose a position", 1, 9);
            int player2 = 1;
            FieldPositions(playfield, userInputPlayer2, player2);
            print2Darray(playfield);
            gameloop = wincondition();
//            int userInputRowPlayer1 = readNumber("Choose Row", 1, 9);
//            int userInputColPlayer1 = readNumber("Choose Col", 1, 3);
//            playfield[userInputRowPlayer1 - 1][userInputColPlayer1 - 1] = 1;
//            int userInputPosition = readNumber("Player 1 choose position", 1, 9);
//            playfield[userInputPosition][userInputPosition] = 1;
//            print2Darray(playfield);
//            int userInputPosition2 = readNumber("Player 2 choose position", 1, 9);
//            playfield[userInputPosition2][userInputPosition2] = 2;
//            print2Darray(playfield);
//            int userInputRowPlayer2 = readNumber("Choose Row", 1, 9);
//            int userInputColPlayer2 = readNumber("Choose Col", 1, 3);
//            playfield[userInputRowPlayer2 - 1][userInputColPlayer2 - 1] = 2;

        }
        System.out.println("Thanks for wasting your time");
    }

    public static int[][] create2DArray() {
        int counter = 1;
        int[][] result = new int[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {

                result[i][j] = counter;
                counter++;
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
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
//            System.out.print("   |  ");

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

    public static void FieldPositions(int[][] field, int input, int player) {
        int row = -1;
        int col = -1;

        if (input == 1) {
            row = 0;
            col = 0;
        } else if (input == 2) {
            row = 0;
            col = 1;
        } else if (input == 3) {
            row = 0;
            col = 2;
        } else if (input == 4) {
            row = 1;
            col = 0;
        } else if (input == 5) {
            row = 1;
            col = 1;
        } else if (input == 6) {
            row = 1;
            col = 2;
        } else if (input == 7) {
            row = 2;
            col = 0;
        } else if (input == 8) {
            row = 2;
            col = 1;
        } else if (input == 9) {
            row = 2;
            col = 2;
        }
        field[row][col] = player;
    }

    public static boolean wincondition() {
        System.out.println("Want to draw something else? (y/n)");
        String response = sc.nextLine();

        if (response.equals("Y") || response.equals("y")) {
            return true;
        } else if (response.equals("N") || response.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            return wincondition();
        }
    }
}

