package Furkan.week05;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class BubblesortMitStringsExtanded {
    public static void main(String[] args) {
        String[] names = new String[]{"Ömer", "Furkan", "Ayla", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
        System.out.println(Arrays.toString(names));
        bubblesortMitBoolean(names, false);
        System.out.println(Arrays.toString(names));
        bubblesortMitIndex(names,5);
        System.out.println(Arrays.toString(names));
    }

    public static void bubblesortMitBoolean(String[] names, boolean sort) {
        Collator collator = Collator.getInstance(Locale.GERMAN);

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (sort == true) {
                    if (collator.compare(names[j], names[j + 1]) > 0) {
                        swap(names, j, j + 1);
                    }
                } else {
                    if (collator.compare(names[j], names[j + 1]) < 0) {
                        swap(names, j, j + 1);
                    }
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

    public static void bubblesortMitIndex(String[] names, int index) {
        if (index < 0 ||  isAWordTooShort(names, index)) {
            System.out.println("Index zu gross, er wurde nicht sortiert");
            return;
        }

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if ((names[j].charAt(index)> names[j + 1].charAt(index))) {
                    swap(names, j, j + 1);
                }
            }
        }
    }

    public static boolean isAWordTooShort (String[] names, int index){
        for (String name : names) {
            if (name.length() < index) {
                return true;
            }
        }
        return false;
    }
}

