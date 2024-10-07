package Thiemo.week04;

import Gyula.ConsoleTools;

public class PascalDreieck {
    public static void main(String[] args) {

        int size = ConsoleTools.readNumber("How big?", 0, 100);
        int[][] array = create2DArray(size);
        print2DArray(array);
        System.out.println();
        int[][] array2 = create2DArray2(size);
        print2DArray(array2);
    }


    public static int[][] create2DArray(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result;
    }

    public static int[][] create2DArray2(int size) {              //AI Suggestion
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            result[i][0] = 1; // First column
            result[0][i] = 1; // First row
        }
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result;
    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
//            System.out.print("[ ");
            for (int j = 0; j < array.length; j++) {
                if (j > 0) {
//                    System.out.print(", ");
                }
                System.out.printf("%7d", array[i][j]);
            }
            System.out.println();
//            System.out.println("]");
        }
    }
}

