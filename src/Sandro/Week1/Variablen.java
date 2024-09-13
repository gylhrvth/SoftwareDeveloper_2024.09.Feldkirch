package Sandro.Week1;

import Sandro.Colors;

public class Variablen {
    public static void main(String[] args) {

        System.out.println(Colors.COLORS[1] +"test" + Colors.RESET);
        System.out.println(Colors.BACKGROUND_COLORS[3] + "Hallo" + Colors.RESET);


        System.out.println("String: "+"Text Wert");                 // String
        System.out.println("Slash als text: "+"\\");
        System.out.println("Anführungszeichen als text: "+"\"");
        System.out.println("Character: "+'C');                      // Character
        System.out.println("Integer: "+150);                        // int
        System.out.println("Max int: "+Integer.MAX_VALUE);          // 32Bit
        System.out.println("Min int: "+Integer.MIN_VALUE);          // 32Bit
        System.out.println("Long: "+9999999999999L);                // long
        System.out.println("Max Long: "+Long.MAX_VALUE);            // 64Bit
        System.out.println("Min Long: "+Long.MIN_VALUE);            // 64Bit
        System.out.println("Float: "+3.14f);                        // float 32 Bit (7stellen)
        System.out.println("Double: "+3.14);                        // double 64 Bit (16stellen)
        System.out.println(true);
        System.out.println(false);

        System.out.println("5 % 2 = " + (5 % 2));                   //Modulo zeigt nur den Rest
        System.out.println("5 / 2 = " + (5 / 2));                   //Teilen von Ganzzahlen
        System.out.println("5f / 2 =" + (5f /2));                   //Teilen von Float oder Double


        double totalWeight = 5.0;
        System.out.println(totalWeight + " / 2.0 = " + (totalWeight / 2.0));
        System.out.println(totalWeight + " / 2   = "+ totalWeight / 2);


        System.out.println("!TRUE: " + !true);
        System.out.println("!FALSE: " + !false);

        System.out.println("TRUE && TRUE: " + (true && true));
        System.out.println("TRUE && FALSE: " + (true && false));
        System.out.println("FALSE && TRUE: " + (false && true));
        System.out.println("FALSE && FALSE: " + (false && false));

        System.out.println("TRUE || TRUE: " + (true || true));
        System.out.println("TRUE ||  FALSE: " + (true || false));
        System.out.println("FALSE || TRUE: " + (false || true));
        System.out.println("FALSE || FALSE: " + (false ||  false));

    }

}

