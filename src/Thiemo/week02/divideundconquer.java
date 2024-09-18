package Thiemo.week02;

import Sandro.Colors;

public class divideundconquer {
    public static void main(String[] args) {

        double mitkomma = 5.0;
        int ohnekomma = 5;
        int start = 0;
        int ende = 20;

        for (int i = start; i <= ende; i++) {
            System.out.println(i + " / " + mitkomma + " = " + (i / mitkomma));
            System.out.println(i + " / " + ohnekomma + " = " + (i / ohnekomma));
            System.out.println(Colors.COLORS[4] + "===================" + Colors.RESET);
        }
//        System.out.println();
//        System.out.println("2. Möglichkeit");

//        for (int i = start; i <= ende; i++) {
//            System.out.println(i + " / 5 = " + (i / 5));
//            System.out.println(i + " / 5.0 = " + i / 5.0);
//        }
    }
}
