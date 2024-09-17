package Akif_Malik.week02;

import Sandro.Colors;

public class AufgabeFaktorial {
    public static void main(String[] args) {
        System.out.println(Colors.COLORS[1] + "------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "Bonus Aufgabe" + Colors.RESET);
        System.out.println(Colors.COLORS[1] + "------------------" + Colors.RESET);
        Faktorial(10, 10);
    }



    public static void Faktorial(int number, int produkt){
        for (int i = 1; i <= 20; i++) {
            System.out.println(Colors.COLORS[6] + i + "!  =" + Colors.RESET);

        }
    }


}
