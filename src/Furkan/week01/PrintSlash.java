package Furkan.week01;

public class PrintSlash {
    public static void main(String[] args) {
        printBackSlash("x", 3);
        printForwardSlash("y", 4);
    }


    public static void printBackSlash(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col == row) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();

        }


    }


    public static void printForwardSlash(String text, int size) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row + col == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");

                }
            }
            System.out.println();
        }
    }
}

