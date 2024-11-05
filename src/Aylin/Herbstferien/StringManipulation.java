package Aylin.Herbstferien;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class StringManipulation {
    public static void main(String[] args) {
        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula", "Ölaf", "Ümit" };
        System.out.println(Arrays.toString(names));
        bubblesortMitBoolean(names, true);
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
}
