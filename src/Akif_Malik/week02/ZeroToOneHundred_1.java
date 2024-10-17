package Akif_Malik.week02;

import Sandro.Colors;

public class ZeroToOneHundred_1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(Colors.COLORS[6] + "--------------------------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Erste Variante (mit float)" + Colors.RESET);
        System.out.println(Colors.COLORS[6] + "--------------------------------------" + Colors.RESET);
        System.out.println();


        float anfang = 0;
        int ende = 100;
//        float aufrunden = 0.1f;


        for (anfang = 0.1f; anfang <= ende; anfang += 0.1f) {
            System.out.printf("%3.1f  \n", anfang);

            System.out.println(Colors.COLORS[4] + "-----" + Colors.RESET);

        }
        System.out.println();
        System.out.println(Colors.COLORS[6] + "--------------------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Zweite Variante (mit integer)" + Colors.RESET);
        System.out.println(Colors.COLORS[6] + "--------------------------------" + Colors.RESET);
        System.out.println();

        int variant2 = 0;
        for (int i = 0; i < 1000; i++) {
            variant2 += 1;
            System.out.println(variant2 / 10.0f);
            System.out.println(Colors.COLORS[6] + "-----" + Colors.RESET);

        }

    }

}

