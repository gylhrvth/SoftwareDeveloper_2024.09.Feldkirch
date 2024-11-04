package Erik.herbstferien_aufgaben.selbsttest;

/*
Erstelle ein int[] und sortiere es mit einem selbsterstellten Bubblesort Algorithmus und gib es dann aus.
Der Bubblesort Algorithmus soll in einer eigenen Methode implementiert werden.
Der Aufruf und die Ausgabe erfolgt in der main Methode.

1. Sortiere der Größe nach aufsteigend (Ascending)
2. Sortiere der Größe nach absteigend (Descending)
*/

import java.util.Arrays;

public class ArrayAufgabe_2 {
    public static void main(String[] args) {
// Erstelltes Array wird jedes Mal überschrieben!
        int[] arr = new int[]{20, 15, 33, 56, 15, 99, 32, 23, 9, 4};
        System.out.println("Aktuelles Array unsortiert: >> " + Arrays.toString(arr));
        int[] ascending = sortArrayAscending(arr);
        System.out.println("Aktuelles Array sortiert (ascending): >> " + Arrays.toString(ascending));
        int[] descending = sortArrayDescending(arr);
        System.out.println("Aktuelles Array sortiert (descending): >> " + Arrays.toString(descending));


    }

    public static int[] sortArrayAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //geht arr durch -1 wegen out of bounce
            for (int j = 0; j < arr.length - 1; j++) { // geht sonlange durch wie das arr lang ist -1 wegen out of bounce
                if (arr[j] > arr[j + 1]) { // exception j+1 bei letzter zahl arr hat 9 will auf 10 zugreiffen
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // die erste zahl arr[j] mit nächster zahl arr[j+1] vergleichen
                // wenn erste zahl kleiner ist als zweite zahl tauschen
                // erste zahl in einer temporären variable speichern
                // erste zahl wird mit zweiter zahl überschrieben
                // zweite zahl wird mit der davor gespeicherten ersten zahl in der temporären variable überschrieben
                // geht solange durch bis alles sortiert ist
            }
        }
        return arr;
    }

    public static int[] sortArrayDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //geht arr durch -1 wegen out of bounce
            for (int j = 0; j < arr.length - 1; j++) { // geht sonlange durch wie das arr lang ist -1 wegen out of bounce
                if (arr[j] < arr[j + 1]) { // exception j+1 bei letzter zahl arr hat 9 will auf 10 zugreiffen
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
