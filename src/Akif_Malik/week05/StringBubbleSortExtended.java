package Akif_Malik.week05;

/*
            Todo:   1. String [] von vorheriger aufgabe verwenden.
                    2. String [] Sortiert ausgeben.
                    3.
 */

import Erik.week05.StringBubblesort;

public class StringBubbleSortExtended {

    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
        boolean switchBetween = false;

        System.out.println("------------------Bubble Sort------------------");
        bubbleSort(names, switchBetween);
        for (String name : names) {
            System.out.println(name);
        }

    }


    public static void bubbleSort(String[] names, boolean switchBetween) {
        if (switchBetween) {
            Erik.week05.StringBubblesort.bubbleSortUpwards(names);

        } else {
            StringBubblesort.bubbleSortDownwards(names);
        }
    }
}
