package Aylin.week04;


import Gyula.WildColors;
import Sandro.Colors;

import java.util.Scanner;

public class PascalTriangle {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("How long should your Pascal Triangle be? ");
        int userInput = sc.nextInt();
        int[][] arr = createPascalTriangle(userInput);
        int size = userInput + 2;
        printPascal(arr, size);
    }

    public static int[][] createPascalTriangle(int size){
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }
        return arr;
    }

    public static void printPascal(int[][] arr, int size){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int blue = (int)Math.round(255 * (0.4 + 0.6 * i / arr.length));
                int green = (int)Math.round(255 * (0.4 + 0.6 * j / arr[i].length));
                int red = (int)Math.round(55 * (0.4 + 0.6 * j / arr[i].length));
                System.out.printf("%s%" + size + "d%s", WildColors.getColor(red, green, blue),  arr[i][j], Colors.RESET);
            }
            System.out.println();
        }
    }
}
