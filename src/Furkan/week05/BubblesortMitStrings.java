package Furkan.week05;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class BubblesortMitStrings {
    public static void main(String[] args) {
        String[] names = new String[]{"Ömer", "Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
        System.out.println(Arrays.toString(names));
        bubbleSortAufsteigend(names);
        System.out.println(Arrays.toString(names));
        bubbleSortAbsteigend(names);
        System.out.println(Arrays.toString(names));
        bubbleSortAufsteigendLex(names);
        System.out.println(Arrays.toString(names));
        bubbleSortAbsteigendLex(names);
        System.out.println(Arrays.toString(names));
    }

    public static void bubbleSortAufsteigend(String[] names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() > names[j + 1].length()) {
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

    public static void bubbleSortAbsteigend(String[] names) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() < names[j + 1].length()) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortAufsteigendLex(String[] names) {
        Collator collator = Collator.getInstance(Locale.GERMAN);
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (collator.compare(names[j], names[j + 1]) > 0) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortAbsteigendLex(String[] names) {
        Collator collator = Collator.getInstance(Locale.GERMAN);
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (collator.compare(names[j], names[j + 1]) < 0) {
                    swap(names, j, j + 1);
                }
            }
        }
    }


}
