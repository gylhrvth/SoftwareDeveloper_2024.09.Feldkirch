package Thiemo.week04;


import Gyula.ConsoleTools;
import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoDArray {
    public static Scanner scanner = new Scanner(System.in);
    public static Random randomGenerator = new Random();

    public static void main(String[] args) {

        int userInput = ConsoleTools.readNumber(Colors.COLORS[6] + "\nHow big Brother?" + Colors.RESET, 0, 9999);
        System.out.println(Colors.COLORS[4] + "as you wanted G. \n" + Colors.RESET);


        int[][] array1 = createAndFillArrayWithoutRandom(userInput);
        System.out.println("Heres the Number Array\n");
        Gyula.week04.ArrayAdvancedExamples.print2DArray(array1);

//        int[] sumRow = sumRows(array1);
//        int[] sumColumn = sumColumns(array1);
//
//        System.out.println(Arrays.toString(sumRow));
//        System.out.println(Arrays.toString(sumColumn));

        int[][] array2 = createAndFillArrayWithRandom(userInput);
        System.out.println("\nHeres the Random Number Array\n");
        Gyula.week04.ArrayAdvancedExamples.print2DArray(array2);

        System.out.print("\nDo you want to sum rows or columns? (r/c): \n");
        char choice = scanner.next().charAt(0);

        if (choice == 'r') {
            int[] rowSums = sumRows(array1);
            System.out.println("Sum of each row Number : \n" + Arrays.toString(rowSums));
            int[] rowSumsRandom = sumRows(array2);
            System.out.println("Sum of each row Random : \n" + Arrays.toString(rowSumsRandom));
        } else if (choice == 'c') {
            int[] colSums = sumColumns(array1);
            System.out.println("Sum of each column Number : \n " + Arrays.toString(colSums));
            int[] colSumsRandom = sumColumns(array2);
            System.out.println("Sum of each column Random : \n" + Arrays.toString(colSumsRandom));
        } else {
            System.out.println("Invalid choice.");
        }

//        int[] sumRowRandom = sumRows(array2);
//        int[] sumColumnRandom = sumColumns(array2);
//
//        System.out.println(Arrays.toString(sumRowRandom));
//        System.out.println(Arrays.toString(sumColumnRandom));


    }


    public static int[][] createAndFillArrayWithRandom(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = randomGenerator.nextInt(101);
            }
        }
        return result;
    }

    public static int[][] createAndFillArrayWithoutRandom(int size) {
        int counter = 0;
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter;
                counter++;
            }

        }
        return array;
    }

    public static int[] sumRows(int[][] array) {
        int[] sums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            sums[i] = sum;
        }
        return sums;
    }

    public static int[] sumColumns(int[][] array) {
        int[] sums = new int[array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j][i];
            }
            sums[i] = sum;
        }
        return sums;
    }
}




