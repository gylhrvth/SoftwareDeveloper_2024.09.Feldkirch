package Akif_Malik.week05;

import Sandro.Colors;

public class StringTesting {
    public static void main(String[] args) {
        String letter = "a ";

        String name01 = "Akif";
        String name02 = "Thiemo";
        String name03 = "Erik";

        System.out.println(Colors.COLORS[4] +  "-.-.-.-.-.-.-.-.-.-.-.-.-.-" + Colors.RESET);
        System.out.println(name01 + " compare To " + name02 + " == " + name01.compareTo(name02));
        System.out.println(name03 + " compare To " + name01 + " == " + name03.compareTo(name01));
        System.out.println(name01 +  " compare To " + name02 + " == " + name01.compareTo(name03));

        System.out.println(Colors.COLORS[4] + "-.-.-.-.-.-.-.-.-.-.-.-.-.-" + Colors.RESET);
        System.out.println(name01.toLowerCase());
        System.out.println(name02.toUpperCase());

        System.out.println(Colors.COLORS[4] + "-.-.-.-.-.-.-.-.-.-.-.-.-.-" +  Colors.RESET);
        System.out.println("hello".concat(" world°!"));
        System.out.println("to".concat("get".concat("her")));
        System.out.println("*!~".concat("°!?".concat("|=°")));

        System.out.println(Colors.COLORS[4] + "-.-.-.-.-.-.-.-.-.-.-.-.-.-" +  Colors.RESET);


    }
}
