package Akif_Malik.week02;

import Sandro.Colors;

public class AufgabeFaktorial {
    public static void main(String[] args) {
        System.out.println(Colors.COLORS[1] + "------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "Bonus Aufgabe" + Colors.RESET);
        System.out.println(Colors.COLORS[1] + "------------------" + Colors.RESET);

        int i = 1;
        long faktorial = 1;
        int count = 20;

        for (i = 1; i <= count; i++) {
            faktorial = faktorial * i;

            System.out.printf("%2d! = %20d \n", i, faktorial);
        }
    }

}
