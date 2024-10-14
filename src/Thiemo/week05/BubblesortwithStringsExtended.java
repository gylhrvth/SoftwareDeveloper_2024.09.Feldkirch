package Thiemo.week05;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class BubblesortwithStringsExtended {
    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula" };
        System.out.println(Arrays.toString(names));
        bubblesortboolean(names,false);



    }

    public static void bubblesortboolean(String [] names,boolean sortAorD){
        if (sortAorD){
            bubblesortlengthAscending(names);
            System.out.println(Arrays.toString(names));
            bubblesortAscendingLex(names);
            System.out.println(Arrays.toString(names));
        }
        else {
            bubblesortlengthDescending(names);
            System.out.println(Arrays.toString(names));
            bubblesortDescendingLex(names);
            System.out.println(Arrays.toString(names));
        }

    }

    public static void bubblesortlengthAscending(String[] names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() > names[j + 1].length()) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static void bubblesortlengthDescending(String[] names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() < names[j + 1].length()) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static void bubblesortAscendingLex(String[] names) {
        Collator collator = Collator.getInstance(Locale.GERMAN);
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (collator.compare(names[j], names[j + 1]) > 0) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static void bubblesortDescendingLex(String[] names) {
        Collator collator = Collator.getInstance(Locale.GERMAN);
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (collator.compare(names[j], names[j + 1]) < 0) {
                    swap(names, j, j + 1);
                }
            }
        }

    }

    public static void swap(String[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


