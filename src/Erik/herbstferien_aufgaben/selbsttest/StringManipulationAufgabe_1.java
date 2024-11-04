package Erik.herbstferien_aufgaben.selbsttest;

import java.util.Arrays;

/*
Verwende den gegebenen String[] und sortiere es mit einem selbsterstellten Bubblesort Algorithmus und gib es dann aus.
Sortiere zuerst nach der Länge der Namen, dann nach dem Alphabet.
Der Bubblesort Algorithmus soll in einer eigenen Methode implementiert werden.
Der Aufruf und die Ausgabe erfolgt in der main Methode.

Sortiere die Namen nach Länge aufsteigend (Ascending)
Sortiere die Namen nach Länge absteigend (Descending)
Sortiere die Namen lexikographisch aufsteigend (Ascending)
Sortiere die Namen lexikographisch absteigend (Descending)
 */
public class StringManipulationAufgabe_1 {
    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula", "Ölaf", "Ümit"};
        String[] copy = makeCopy(names);

        // mit .length() länge der Strings bestimmen und sortieren
        // Bubblesort schreiben
        // for i schleife einmal array durchghen
        // 2. For i schleife um die aktueller zahl mit der zweiten zahl zu vergleichen
        // 1. und 2. Zahl vergleichen wenn größer/kleiner tauschen
        // Erster Wert wird in temp Variable gespeichert
        // dann wird erster wert überschrieben
        // zweiter werd übernimmt erster wert der temporär gespeichert wurde
        System.out.println("Original names: " + Arrays.toString(names));
        String[] namesSortedDescending = sortNamesDescending(copy);
        System.out.println("Sorted Names Descending: " + Arrays.toString(namesSortedDescending));
        String[] namesSortedAscending = sortNamesAscending(names);
        System.out.println("Sorted Names Ascending: " + Arrays.toString(namesSortedAscending));
        String[] namesSortedLexioDescending = sortNamesLexioDescending(names);
        System.out.println("Sorted Names lexikographisch Descending: " + Arrays.toString(namesSortedAscending));
        String[] namesSortedLexioAscending = sortNamesLexioAscending(names);
        System.out.println("Sorted Names lexikographisch Ascending: " + Arrays.toString(namesSortedAscending));
    }

    public static String[] makeCopy(String[] names) {
        String[] copy = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            copy[i] = names[i];
        }
        return copy;
    }

    public static String[] sortNamesDescending(String[] copy) {
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1; j++) {
                if (copy[j].length() < copy[j + 1].length()) {
                    String temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        return copy;
    }

    public static String[] sortNamesAscending(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() > names[j + 1].length()) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
        return names;
    }

    public static String[] sortNamesLexioDescending(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].compareTo(names[j + 1]) < names[j + 1].compareTo(names[j])) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
        return names;
    }

    public static String[] sortNamesLexioAscending(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > names[j + 1].compareTo(names[j])) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
        return names;
    }
}
