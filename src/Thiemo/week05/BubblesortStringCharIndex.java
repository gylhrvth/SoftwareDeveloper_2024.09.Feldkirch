package Thiemo.week05;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class BubblesortStringCharIndex {
    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
        System.out.println("Before sorting : " + Arrays.toString(names));
        bubblesortLexAscending(names,2);

    }

    public static void bubblesortLexAscending(String[] names, int index) {
        if (index < 0 ||  isAWordTooShort(names, index)) {
            System.out.println("Index too large or invalid, sorting was not performed.");
            return;
        }
        Collator collator = Collator.getInstance(Locale.GERMAN);
//Sort with the character at this specific indexposition
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {

                if (names[j].charAt(index) > names[j + 1].charAt(index)) {
                    Thiemo.week05.BubblesortWithStrings.swap(names, j, j + 1);

                }
            }
        }        System.out.println("After sorting : " + Arrays.toString(names));
    }
    public static boolean isAWordTooShort (String[] names, int index){
        for (String name : names) {
            System.out.println(name);
            if (name.length() <= index) {
                return true;
            }
        }
        return false;
    }
}
