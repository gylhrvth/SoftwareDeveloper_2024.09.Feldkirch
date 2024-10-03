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
        System.out.println("Here's the Number Array\n");
        Gyula.week04.ArrayAdvancedExamples.print2DArray(array1);
//        int[] sumRow = sumRows(array1);
//        int[] sumColumn = sumColumns(array1);
//
//        System.out.println(Arrays.toString(sumRow));
//        System.out.println(Arrays.toString(sumColumn));

        int[][] array2 = createAndFillArrayWithRandom(userInput);
        System.out.println("\nHere's the Random Number Array\n");
        Gyula.week04.ArrayAdvancedExamples.print2DArray(array2);

        System.out.print("\nDo you want to sum rows or columns? (r/c): \n");
        String choice = scanner.nextLine();

        if (choice .equals("r")) {
            int[] rowSums = sumX(array1);
            Gyula.week04.ArrayAdvancedExamples.print2DArray(array1);
            System.out.println(Arrays.toString(rowSums)+ "\nSum of each X Number\n");
//            System.out.println("Sum of each row Number : \n" + Arrays.toString(rowSums));
            int[] rowSumsRandom = sumX(array2);
            Gyula.week04.ArrayAdvancedExamples.print2DArray(array2);
            System.out.println(Arrays.toString(rowSumsRandom)+ "\nSum of each X Random\n");
//            System.out.println("Sum of each row Random : \n" + Arrays.toString(rowSumsRandom));


        } else if (choice .equals("c")) {
            int[] colSums = sumY(array1);
            Gyula.week04.ArrayAdvancedExamples.print2DArray(array1);
            System.out.println(Arrays.toString(colSums)+ "\nSum of each Y Number \n");
            int[] colSumsRandom = sumY(array2);
            Gyula.week04.ArrayAdvancedExamples.print2DArray(array2);
            System.out.println(Arrays.toString(colSumsRandom)+ "\nSum of each Y Random \n");
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
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomGenerator.nextInt(101);
            }
        }
        return array;
    }

    public static int[][] createAndFillArrayWithoutRandom(int size) {
        int counter = size*size - 1;
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter;
                counter--;
            }

        }
        return array;
    }

    public static int[] sumX(int[][] array) {
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

    public static int[] sumY(int[][] array) {
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

//    public static void print2DArray(int [][] array){
//        for (int i = 0; i < ; i++) {
//
//        }
//
//    }
}




