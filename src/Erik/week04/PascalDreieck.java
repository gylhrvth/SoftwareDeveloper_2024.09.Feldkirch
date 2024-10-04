package Erik.week04;

import java.util.Random;
import java.util.Scanner;

public class PascalDreieck {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        int[][] arr = create2DArray(10, 10);
        printPascalArray(arr);

    }

    public static int[][] create2DArray(int row, int col) {
        int[][] result = new int[row][col];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

            }
        }
        return result;
    }

    public static void printPascalArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
//                    arr[i][j] = arr[i][j - 1] + arr[j][i - 1];  [i][j] richtig || [j][i] falsch
                }
                System.out.printf("%6d ", arr[i][j]);
            }
            System.out.println();
        }
    }

}
