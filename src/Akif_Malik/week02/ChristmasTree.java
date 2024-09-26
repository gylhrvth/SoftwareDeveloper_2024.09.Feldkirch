package Akif_Malik.week02;

import Sandro.Colors;

public class ChristmasTree {
    public static void main(String[] args) {
        System.out.println("ChristmasTree");
        System.out.println();
        printChristmasTree(Colors.COLORS[2] + "* " + Colors.RESET, 9);
    }

    public static void printChristmasTree(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2* size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print(text);
                } else if (col == row + size - 1) {
                    System.out.print(text);
                } else if (row == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(Colors.COLORS[3] + ". " + Colors.RESET);
                }
            }
            System.out.println();
        }
        for (int leaves = 0; leaves < size; leaves++) {
            System.out.print(Colors.COLORS[1] + "O   " + Colors.RESET);


        }
        System.out.println();

        for (int trunk = 0; trunk < size / 2 - 1; trunk++) {
            System.out.printf(Colors.COLORS[7] + "%19s \n" + Colors.RESET, "+++++");


        }
        System.out.println();


    }

}





