package Akif_Malik.week02;

import Sandro.Colors;

public class DivideAndConquer {
    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println(Colors.COLORS[6] + "----------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "-*divide and conquer*-" + Colors.RESET);
        System.out.println(Colors.COLORS[6] + "----------------------" + Colors.RESET);
        System.out.println();

        int b = 5;
        float a = 5.0f;

        for (int i = 0; i < 21; i++) {
            System.out.println(i + " / " + b + " = " + i / b);
            System.out.println(i + " / " + a + " = " + i / a);
            System.out.println(Colors.COLORS[4] + "-----------------" + Colors.RESET);
        }


    }
}

