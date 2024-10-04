package Aylin.week04;

import Gyula.WildColors;
import Sandro.Colors;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoDArray {
    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("How many rows should your array have? ");
        int row = sc.nextInt();
        System.out.print("How many columns should your array have? ");
        int col = sc.nextInt();
        int[][] arrTwoD = fillArrayWithRandomNumbers(row, col);
        print2DArray(arrTwoD);
        System.out.println("Would you prefer to print the sum of the rows or the columns?(r/c)");
        printSums(arrTwoD);
    }

    public static int[][] fillArrayWithRandomNumbers(int row, int col){
        int[][] arrTwoD = new int[row][col];
        for (int i = 0; i < arrTwoD.length; i++) {
            for (int j = 0; j < arrTwoD[i].length; j++) {
                arrTwoD[i][j] = random.nextInt(101);
            }
        }
        return arrTwoD;
    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int blue = (int)Math.round(255 * (0.4 + 0.6 * i / arr.length));
                int green = (int)Math.round(255 * (0.4 + 0.6 * j / arr[i].length));
                if (j == 0){
                    System.out.printf("%s%4d%s", WildColors.getColor(45, green, blue),  arr[i][j], Colors.RESET);

                }else{
                    System.out.printf(" | %s%4d%s", WildColors.getColor(45, green, blue),  arr[i][j], Colors.RESET);

                }
            }
            System.out.println();
        }
    }

    public static int sumArrayCol(int[][] arr, int colIndex){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static int sumArrayRow(int[][] arr, int rowIndex){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][rowIndex];
            }
        }
        return sum;
    }

    public static void printSums(int[][] arr){
        boolean validInput = false;

        while (!validInput) {
            String choice = sc.next().toLowerCase();
            if (choice.equals("r")) {
                int[] rowSums = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    rowSums[i] = sumArrayRow(arr, i);
                }
                System.out.println("Sum of each row: " + Colors.COLORS[6] + Arrays.toString(rowSums) + Colors.RESET);
                validInput = true;
            } else if (choice.equals("c")) {
                int[] colSums = new int[arr[0].length];
                for (int j = 0; j < arr[0].length; j++) {
                    colSums[j] = sumArrayCol(arr, j);
                }
                System.out.println("Sum of each column: " + Colors.COLORS[4] + Arrays.toString(colSums) + Colors.RESET);
                validInput = true;
            } else {
                System.out.println("Invalid choice. Please enter 'r' or 'c'.");
                validInput = false;
            }
        }
    }
}