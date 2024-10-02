package Gyula.week04;

import Gyula.WildColors;
import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;

public class ArrayAdvancedExamples {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] number = new int[10];
        for (int i = 0; i < number.length; i++) {
            number[i] = 100;
        }
        System.out.println(Arrays.toString(number));

        double[] doubles = new double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = 0.5;
        }
        System.out.println(Arrays.toString(doubles));

        boolean[] jaodernein = new boolean[3];
        for (int i = 0; i < jaodernein.length; i++) {
            jaodernein[i] = true;
        }
        System.out.println(Arrays.toString(jaodernein));

        int counter = 1;
        int[][] arraysOfArray = new int[4][];
        for (int i = 0; i < arraysOfArray.length; i++) {
            arraysOfArray[i] = new int[1 + 2 * i];
            for (int j = 0; j < arraysOfArray[i].length; j++) {
                arraysOfArray[i][j] = counter;
                counter++;
            }
        }


        System.out.println(Arrays.toString(arraysOfArray)); // Doesn't work
        print2DArray(arraysOfArray);

        System.out.println("-------------------");
        int[][] matrix = new int[5][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }
        print2DArray(matrix);

    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j > 0){
                    System.out.print(", ");
                }
                System.out.printf("%s%4d%s", WildColors.getColor(204, 0, 102),  arr[i][j], Colors.RESET);
            }
            System.out.println("]");
        }
    }
}
