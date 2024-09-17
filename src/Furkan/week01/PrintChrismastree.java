package Furkan.week01;

public class PrintChrismastree {
    public static void main(String[] args) {
        prinChristmastree(9);

    }


    public static void prinChristmastree(int size) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print("A");
                } else if (col == row + size - 1) {
                    System.out.print("B");
                } else if (row == size - 1) {
                    System.out.print("C");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        for (int leaves = 0; leaves < size; leaves++) {
            System.out.print("0 ");
        }
        System.out.println();

        for (int trunk = 0; trunk <= size - 1; trunk++) {
            System.out.print(" ");
        }
        System.out.println("");
    }


}

