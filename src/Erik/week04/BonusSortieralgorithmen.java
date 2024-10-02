package Erik.week04;

import Erik.week03.ArrayRandomNumberCount;
import Sandro.Colors;

import java.util.Arrays;

public class BonusSortieralgorithmen { // Heap Sort, shell sort, gnome sort , Empfehlung: insertion sort merge sort cocktail sort
    public static void main(String[] args) {

        int arraySize = 5;
        int[] randArr = new int[arraySize];
        ArrayRandomNumberCount.fillArrayWithRandomGen(randArr);
        int[] randArrCop1 = makeCopy(randArr);
        int[] randArrCop2 = makeCopy(randArr);
        int[] randArrCop3 = makeCopy(randArr);
        System.out.println("--------------------------------------------");
        System.out.printf(Colors.COLORS[1] + "Original Array without Sorting: >> " + Arrays.toString(randArr) + "\n" + Colors.RESET);
        System.out.println("--------------------------------------------");
        System.out.printf(Colors.COLORS[2] + "Copied Array after sorting with Shell Sort: >> " + Arrays.toString(shellSort(randArrCop1)) + "\n" + Colors.RESET);
        System.out.println("--------------------------------------------");
        System.out.printf(Colors.COLORS[4] + "Copied Array after sorting with Gnome Sort: >> " + Arrays.toString(gnomeSort(randArrCop2)) + "\n" + Colors.RESET);
        System.out.println("--------------------------------------------");
        System.out.printf(Colors.COLORS[5] + "Copied Array after sorting with Cocktail Shaker Sort: >> " + Arrays.toString(cocktailShakerSortWorking(randArrCop3)) + "\n" + Colors.RESET);
        System.out.println("--------------------------------------------");

    }

    public static int[] makeCopy(int[] randArr) {
        int[] copy = new int[randArr.length];

        for (int i = 0; i < randArr.length; i++) {
            copy[i] = randArr[i];
        }
        return copy;
    }

    public static void swap(int[] randArr, int i, int j) {
        if (i >= 0 && j >= 0 && i < randArr.length && j < randArr.length) {
            int temp = randArr[i];
            randArr[i] = randArr[j];
            randArr[j] = temp;
        }
    }

    public static int[] shellSort(int[] randArrCop1) {
        // int arrSize zur abkürzung von unten stehendem
        int arrSize = randArrCop1.length;

        for (int gap = arrSize / 2; gap > 0; gap /= 2) { //gap wird halbiert so lange bis er 0 erreicht
            for (int i = gap; i < arrSize; i++) {  // Iteriert über das Array, beginnend beim gap
                int temp = randArrCop1[i];  //speichert den aktuellen Wert von randArrCop1[i] in den int temp
                int j; // int j wird außerhalb definiert das außerhalb der schleife der randArrCop1[j] wieder mit dem temp int definiert wird
                for (j = i; j >= gap && randArrCop1[j - gap] > temp; j -= gap) { // verschiebt alle zahlen die größer sind als temp um gap position nac rechts
                    randArrCop1[j] = randArrCop1[j - gap]; // Verschiebt die Zahl an Position j-gap nach rechts zu Pos j.
//                        randArrCop1[j] = temp; geht nicht bzw sortiert nicht
                }
                randArrCop1[j] = temp; // gibt den gespeicherten Array[i] wert zurück in den randArrCop1[j].
            }
        }
        return randArrCop1;
    }

    public static int[] gnomeSort(int[] randArrCop2) {
        int i = 1;
        int n = randArrCop2.length;
        while (i < n) {
            if (randArrCop2[i] >= randArrCop2[i - 1]) {
                i++;
            } else {
                int temp = randArrCop2[i];
                randArrCop2[i] = randArrCop2[i - 1];
                randArrCop2[i - 1] = temp;
//              swap(randArrCop2[i], randArrCop2[i-1]);
                if (i > 1) {
                    i--;
                }
            }
        }
        return randArrCop2;
    }

    public static int[] cocktailShakerSortBugged(int[] randArrCop3) { // Geht nur bestimmt, hängt ab und zu im Code fest

        int lo = 1;
        int hi = randArrCop3.length - 1;
        int mov = lo;

        while (lo < hi) {
            for (int i = hi; i > lo + 1; i--) {
                if (randArrCop3[i - 1] > randArrCop3[i]) {
                    int temp = randArrCop3[i];
                    randArrCop3[i] = randArrCop3[i - 1];
                    randArrCop3[i - 1] = temp;
                    mov = i;
//                    swap(randArrCop3[i-1], randArrCop3[i]); //Warum funktioniert das so nicht??
                }
            }
            lo = mov;
            for (int i = lo; i < hi - 1; i++) {
                if (randArrCop3[i] > randArrCop3[i + 1]) {
                    int temp = randArrCop3[i];
                    randArrCop3[i] = randArrCop3[i + 1];
                    mov = i;
                }
                hi = mov;
            }
        }
        return randArrCop3;
    }

    public static int[] cocktailShakerSortWorking(int[] randArrCop3) { //irgendwas funktioniert nicht anschauen!

        int lo = 0;
        int hi = randArrCop3.length - 1;
        int mov = lo;

        while (lo < hi) {
            for (int i = hi; i > lo; i--) {
                if (randArrCop3[i - 1] > randArrCop3[i]) {
                    int temp = randArrCop3[i];
                    randArrCop3[i] = randArrCop3[i - 1];
                    randArrCop3[i - 1] = temp;
                    mov = i;
                    swap(randArrCop3, i-1, i); //Warum funktioniert das so nicht??
                }
            }
            lo = mov;

            for (int i = lo; i < hi; i++) {
                if (randArrCop3[i] > randArrCop3[i + 1]) {
                    int temp = randArrCop3[i];
                    randArrCop3[i] = randArrCop3[i + 1];
                    mov = i;
                }
            }
            hi = mov;
        }
        return randArrCop3;
    }
}

















