package Erik.week04;

import Erik.week03.ArrayRandomNumberCount;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {

        int arraySize = 5;
        int[] randArrOrg = new int[arraySize];
        ArrayRandomNumberCount.fillArrayWithRandomGen(randArrOrg);
        int[] randArrCopy1 = makeCopy(randArrOrg);
        int[] randArrCopy2 = makeCopy(randArrOrg);


        System.out.println(Arrays.toString(randArrOrg) + " Original Array");
        System.out.println("--------------------------------------------");
        bubbleSortUpwards(randArrCopy1);
        System.out.println("--------------------------------------------");
        System.out.println("Copy 1 []: >> " + Arrays.toString(randArrCopy1) + " Upward Ergebnis");
        System.out.println("============================================");
        System.out.println("Original []: >> " + Arrays.toString(randArrOrg));
        System.out.println("============================================");
        bubbleSortDownwards(randArrCopy2);
        System.out.println("--------------------------------------------");
        System.out.println("Copy 2 []: >> " + Arrays.toString(randArrCopy2) + " Downward Ergebnis");
        System.out.println("--------------------------------------------");

    }

    public static int[] makeCopy(int[] randArrOrg) {
        int[] copy = new int[randArrOrg.length];
        for (int i = 0; i < randArrOrg.length; i++) {
            copy[i] = randArrOrg[i];
        }
        return copy;
    }

    // Die erste For I Schleife geht nur die Wiederholung der Ausführung der zweiten Schleife an. Die zweite Schleife bringt di Zahlen in die richtige Position
    public static void bubbleSortUpwards(int[] randArrCopy1) {
        for (int i = 0; i < randArrCopy1.length -1; i++) { // Die erste For I Schleife geht die zweite Schleife so oft durch wie das Array lang ist sprich so lange bis alle großen zahlen von rechts nach links sortiert sind.
            for (int j = 0; j < randArrCopy1.length - 1; j++) {  // Die zweite For I Schleife bringt den höchsten Wert auf die letzte Stelle nach rechts
                System.out.println("Copy 1: >> " + Arrays.toString(randArrCopy1)); //Veranschaulichung was er macht
                if (randArrCopy1[j] > randArrCopy1[j + 1]) { // (j+1) nimmt den aktuellen wert j mit dem zweiten wert (+1) von j
                    int temp = randArrCopy1[j + 1];    // Der aktuelle Wert von randArrCopy1[j] <-- von Position i wird in den int temp gespeichert
                    randArrCopy1[j + 1] = randArrCopy1[j];  // Der aktuelle Wert von randArrCopy1[i] wird mit dem wert von randArrCopy1[j] überschrieben
                    randArrCopy1[j] = temp;        // Der Leerstehende randArrCopy1[j] wird befüllt mit dem temp platzhalter/wert von randArrCopy1[i]
                }
            }
            System.out.println();
        }
    }

    public static void bubbleSortDownwards(int[] randArrCopy2) {
        for (int i = 0; i < randArrCopy2.length - i; i++) { // randArrCopy2.length - i <-- ist dafür da dass er die Unnötigen Sortierschritte nicht mehr macht/nicht mehr so oft

            for (int j = 0; j < randArrCopy2.length - 1; j++) {
                System.out.println("Copy 2: >> " + Arrays.toString(randArrCopy2));
                if (randArrCopy2[j] < randArrCopy2[j + 1]) {
                    int temp = randArrCopy2[j + 1];
                    randArrCopy2[j + 1] = randArrCopy2[j];
                    randArrCopy2[j] = temp;
                }
            }

            System.out.println();
        }
    }

}
