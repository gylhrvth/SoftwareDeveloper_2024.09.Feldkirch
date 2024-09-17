package Akif_Malik.week02;

import Sandro.Colors;

public class ZeroToOneHundred_2 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(Colors.COLORS[6] + "--------------------------" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "0 to 100 with one and two digits" + Colors.RESET);
        System.out.println(Colors.COLORS[6] + "--------------------------" + Colors.RESET);
        System.out.println();

        float anfang = 0;
        int ende = 100;
        float aufrunden = 0.1f;


        for (anfang = 0.1f; anfang <= ende; anfang += 0.1f) {
            System.out.printf("%5.1f   <==  Result one digit  \n", anfang);
            System.out.printf("%6.2f  <==  Result two digit  \n", anfang);

            System.out.println(Colors.COLORS[4] + "-------------------------------" + Colors.RESET);

        }
        System.out.println();
        System.out.println();


    }

}
