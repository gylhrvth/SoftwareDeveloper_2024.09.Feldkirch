package Erik.herbstferien_aufgaben.selbsttest;

/*
Ertelle jeweils eine Methode für Minimum (min), Maximum (max), und Durchschnitt (avg),
welche den jeweiligen Wert für ein übergebenes int[] berechnet.
Teste alle Methoden in der main Methode mit allen gegebenen int[] der Klasse
 */

public class ArraysAufgabe_1 {
    public static void main(String[] args) {

        int[] arr = new int[]{20, 15, 33, 56, 15, 99, 32, 23, 9, 4}; // kann noch durch Zufalls Zahlen getauscht werden

        int min = giveMinValue(arr);
        int max = giveMaxValue(arr);
        int avg = giveAverageValueWithForI(arr);
        int avgBonus = giveAverageValueWithForEach(arr);
        System.out.println("Die niedrigste Zahl im Array ist: >> " + min);
        System.out.println("Die größte Zahl im Array ist: >> " + max);
        System.out.println("Die Average Zahl im Array ist: >> " + avg);
        System.out.println("Die Average Zahl im Array ist: >> " + avgBonus);
    }

    public static int giveMinValue(int[] arr) {
        int minValue = Integer.MAX_VALUE;   // nicht gewusst das ich Integer. schreiben muss für die MAX_VALUE (nachgeschaut)
        // Alternative minValue = arr[0] im Kopf gehabt wollte aber das andere schreiben
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static int giveMaxValue(int[] arr) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    // 1. Version
    public static int giveAverageValueWithForI(int[] arr) {
        int avgValue = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // Alle zahlen miteinander summieren; in sum speichern
        }
        avgValue = sum / arr.length;    // summe ist summe dividiert durch die Anzahl der vorhandenen Zahlen
        return avgValue;
    }

    // 2. Version gemacht einfach so (Aufbau von For Each nachgeschaut; habs vergessen)
    public static int giveAverageValueWithForEach(int[] arr) {
        int avgValue = 0;
        int sum = 0;
        // geht das array durch und speichert den derzeitigen Wert beim Durchgehen in die value Varibale?
        for (int value : arr) { // und geht das weiter bis er einmal durch ist, oder? (Nachfragen) int value ist also arr[i]?
            sum = sum + value;
            value = sum / arr.length;
            avgValue = value;
        }
        return avgValue;
    }
}