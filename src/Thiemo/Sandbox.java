package Thiemo;

import java.util.Arrays;
import java.util.Locale;

public class Sandbox {
    public static void main(String[] args) {


        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
        int [] age = new int[]{1,2,3,4,5,6,7};

        System.out.println(Arrays.toString(names)+ Arrays.toString(age));

        int totalLength = names.length;
        String[] merged = new String[totalLength];

        for (int i = 0; i < names.length; i++) {
            merged[i] = names[i] + age[i];

//            merged[i*2] = names[i];
//            merged[i*2+1] = String.valueOf(age[i]);

        }

        System.out.println(Arrays.toString(merged));


        String name1 = "Thiem";

        String name2 = "Thiemo";

        Integer zahl = 5;



        System.out.println("Length of name1: " + name1.length());

        System.out.println("Length of name2: " + name2.length());

        int lengthComparison = Integer.compare(name2.length(),zahl);


        System.out.println("Length comparsion result : " + lengthComparison);

        System.out.println(name1 + " " + name2 + " " + name1.compareTo(name2));

        System.out.println(Arrays.toString(names));


        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toUpperCase();
        }
        System.out.println("\n" + Arrays.toString(names));

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toUpperCase(Locale.US);
        }
        System.out.println("\n" + Arrays.toString(names) + "\n");

        for (String name : names) {
            System.out.println(Arrays.toString(name.toCharArray()));
        }
        System.out.println(Arrays.toString(names));

        char[] letters = names[2].toCharArray();
        System.out.println("\n" + Arrays.toString(letters));

        char letter = names[2].charAt(2);
        System.out.println(letter);


    }
}

