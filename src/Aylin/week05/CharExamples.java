package Aylin.week05;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;

public class CharExamples {
    public static void main(String[] args) {
        System.out.println("Char nomal");
        char text = 'A';
        System.out.println(text);

        System.out.println("--------------");
        System.out.println("CharAt");

        String name = "Aylin";
        char letter = name.charAt(2);
        System.out.println(letter);

        System.out.println("-------------");
        System.out.println("String and Chars");

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula" };
        char specName = names[1].charAt(4);                                                                 //hier beziehe ich den zweiten Namen meines Arrays und rufe das Zeichen an Index 4 (Buchstabe 5) ab.
        System.out.println(specName);

        System.out.println("------------");
        System.out.println("Compare to");

        String car1 = "Mercedes";                                                                          // Compare to schaut zuerst, welches String länger ist (1 länger als 2) daher kommt eine positive zahl
        String car2= "togg";                                                                               // danach vergleicht er die ersten Buchstaben, sobald ein Buchstabe nicht richtig ist, gibt er uns die Differenz dieser Zahl aus
        System.out.println(car1 + " compare to " + car2 + " = " + car1.compareTo(car2));

        System.out.println("Compare to ignore case");

        System.out.println(car1.compareToIgnoreCase(car2));                                                //macht genau das gleiche wie compare to NUR hier wird nicht auf Gross- Kleinschreibung geachtet

        System.out.println("------------");
        System.out.println("Concat");

        System.out.println(car2.concat(" is the best car brand!"));

        System.out.println("------------");
        System.out.println("Content equals");
        System.out.println(car1.contentEquals(car2));                                                      //true if this String represents the same sequence of char values as the specified sequence, false otherwise

        System.out.println("------------");
        System.out.println("Copy Value of");

        String origin = "Europa";
        String copyValueOf = origin;
        System.out.println(copyValueOf);

        System.out.println("------------");
        System.out.println("Ends with");
        System.out.println();

        System.out.println("------------");
        System.out.println("To Upper Case");

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toUpperCase(Locale.TRADITIONAL_CHINESE);
        }
        System.out.println(Arrays.toString(names));

    }
}
