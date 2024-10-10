package Gyula.week05;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class SortAlphabetical {
    public static void main(String[] args) {
        String[] names = new String[]{"Ömer", "Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula" };
        System.out.println(Arrays.toString(names));
        bubbleSortByAlphabetical(names);
        System.out.println(Arrays.toString(names));
    }


    public static void bubbleSortByAlphabetical(String[] arr){
        Collator collator = Collator.getInstance(Locale.GERMAN);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (collator.compare(arr[j], arr[j + 1]) > 0){
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
