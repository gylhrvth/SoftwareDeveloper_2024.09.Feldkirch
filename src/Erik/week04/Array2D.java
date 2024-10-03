package Erik.week04;

import Gyula.WildColors;
import Sandro.Colors;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
           Todo:    1. Mache einen Random Generator. ♥
                    2. Mache eine Methode die den 2D Array mit Zufallszahlen von 0-100 befüllt. ♥
                    3. Mach ein try/catch in einer UserInput Methode. ♥
                    3.1 Try/catch Block erweitern mit while schleife, boolean, if/else, für falschen Input. ♥
                    4. Mach eine Methode die für das Zusammenrechnen der Zeilen/Spalten zuständig ist.
                    5. Mach eine Print Methode um die Ergebnisse aus zu printen.
                    Erklärung:
                    Frage den User ob er die Summe aller Zeilen oder die Summe aller Spalten haben will.
                    Alle Summen von Zeile oder Alle Summen von allen Spalten einzeln geben.
 */

public class Array2D {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // twoDArr = Two Dimension Array || int[][] twoDArr = new int[5][6] <-- [5]Reihen(row);[6]Spalten(column/col)
        System.out.println("======================================");
        int[][] twoDArr = createAndFillTwoDArrayWithRandomNumbers(5, 6);
        System.out.println("   Array Filled with Random Numbers \n" + "================Display=============== \n");
        print2DArrayWithColorsAndFormation(twoDArr);
        System.out.println();
        System.out.println("====================================== \n");
        logicBehindUserInput(twoDArr);
    }

    public static int[][] createAndFillTwoDArrayWithRandomNumbers(int row, int col) {
        int[][] result = new int[row][col];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = rand.nextInt(101);
            }
        }
        return result;
    }

    public static void print2DArrayWithColorsAndFormation(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                double hue = WildColors.partValue(50, 200, i, arr.length);
                double light = WildColors.partValue(40, 70, j, arr[i].length) / 100.0;
                System.out.printf("%s%4d%s", WildColors.getColorFromHSL(hue, 0.8, light), arr[i][j], Colors.RESET);
            }
            System.out.println("]");
        }
    }

    public static void logicBehindUserInput(int[][] twoDimArr) {
        int choice = controlUserInput("Which of these two Options you want to Print out?\n" +
                "1) All Row Results\n" +
                "2) All Column Results\n" + ">> ", 1, 2);
        if (choice == 1) {
            System.out.println("The Results from All the Rows are: >> " + Arrays.toString(calculateSumFromRowPart(twoDimArr)));
        } else if (choice == 2) {
            System.out.println("The Results from All the Columns are: >> " + Arrays.toString(calculateSumFromColPart(twoDimArr)));
        }
    }

    public static int controlUserInput(String msg, int minValue, int maxValue) {
        int userInput = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                System.out.print(msg);
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println("You need to Choose between Option 1 and Option 2");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error! You need to give me a Number");
            }
            sc.nextLine();
        }
        return userInput;
    }

    public static int[] calculateSumFromRowPart(int[][] arr) {
        int[] allRowSums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) { //geht einmal durch das array
            for (int j = 0; j < arr[i].length; j++) { //geht einmal durch die spalten vom array sollte..
                allRowSums[i] = allRowSums[i] + arr[i][j];
            }
        }
        return allRowSums;
    }

    public static int[] calculateSumFromColPart(int[][] arr) {
        int[] allColSums = new int[arr[0].length]; // [0] Position 0 schaut die erste Schublade an

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                allColSums[j] += arr[i][j];
            }
        }
        return allColSums;
    }


}
