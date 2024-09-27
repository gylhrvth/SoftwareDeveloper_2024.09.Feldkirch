package Sandro.Week3;

import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    static Random rand = new Random();
    public static void main(String[] args) {

    int [] testArray = createRandomNumbArray(10);
//    printDividerLine("Original Random Array");
//    printArrayWithForI(testArray);
//    bubbleSortAsc(testArray);
//    printDividerLine("SortedArrayAscending");
//    printArrayWithForI(testArray);
    printDividerLine("BubbleSort Progression");
    int [] progression = createRandomNumbArray(10);
    printBubbleSortProgression(progression);

    }

    public static void bubbleSortAsc(int [] random ) {
        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < random.length - 1; j++) {                        //why .lenght-1? What if not, what happens?
                if (random[j]<random[j+1]){                                      //if ... looking for the smaller number, if left number is smaller... swamp!

                    //SWAP Section
                    //C = A
                    //A = B
                    //B = C
                    int temp = random[j];                                        //create a temporary int Var, to Store the information we are gonna swap out.
                    random[j] = random[j+1];                                     //swap numbers ...
                    random[j+1] = temp;                                          //swap number from temporary storage back into a number ...
                }
            }
        }

    }

    public static void printBubbleSortProgression (int [] arr){
    int counter = 0;
    int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                printArrayWithForI(arr);
                System.out.println("Compare "+ arr[j]+ " ... with ... "+ arr[j+1]);
                counter ++;
                if (arr[j]<arr[j+1]){
                    System.out.println(Colors.COLORS[2]+arr[j]+Colors.RESET+ " is smaller then "+Colors.COLORS[4]+ arr[j+1]+Colors.RESET);
                    printArrayBubblesort(arr,j,j+1);
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                    System.out.println(Colors.COLORS[2]+arr[j]+Colors.RESET+Colors.COLORS[1]+"... swaped place with ..."+Colors.RESET+Colors.COLORS[4]+ arr[j+1]+Colors.RESET);
                    swaps ++;
                    printArrayBubblesort(arr,j+1,j);
                }
                System.out.println("#".repeat(50));
            }

        }
        System.out.println("Bubblesort has compared "+ counter + " Numbers, to sort my Array");
        System.out.println(Colors.COLORS[1]+"It has swaped "+ swaps + " Numbers to sort my Array"+Colors.RESET);

    }
    public static void printDividerLine(String text) {
        int charcounter = text.length();
        int linecounter = 50;
        String symbol = "#";
        int left = 0;
        int right = 0;
        if (charcounter % 2 == 0) {
            left = (linecounter - charcounter) / 2;
            right = (linecounter - charcounter) / 2;
        } else {
            left = (((linecounter - charcounter) / 2)+1);
            right = ((linecounter - charcounter) / 2);
        }

        System.out.println(symbol.repeat(left) + text + symbol.repeat(right));

    }
    public static void printArrayWithForI(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }

        }
        System.out.print("]");
        System.out.println();
    }
    public static void printArrayBubblesort(int[] arr,int index1, int index2) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                if(i == index1){
                    System.out.print(Colors.COLORS[2]+arr[i]+Colors.RESET);
                } else if (i == index2) {
                    System.out.print(Colors.COLORS[4]+arr[i]+Colors.RESET);
                } else{
                    System.out.print(arr[i]);
                }

            } else {
                if(i == index1){
                    System.out.print(Colors.COLORS[2]+arr[i]+Colors.RESET + ", ");
                }else if(i == index2){
                    System.out.print(Colors.COLORS[4]+arr[i]+Colors.RESET + ", ");
                }else{
                    System.out.print(arr[i] + ", ");
                }

            }

        }
        System.out.print("]");
        System.out.println();
    }
    public static int[] createRandomNumbArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 101);
        }
        return arr;
    }

}
