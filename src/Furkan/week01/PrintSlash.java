package Furkan.week01;

public class PrintSlash {
    public static void main(String[] args) {
        printBackSlash("x", 3);
        printForwardSlash("y", 4);
        printSlash("y", 4, false);
    }

    public static void printSlash(String text, int size, boolean left) {
        if (left == true) {

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

        } else {

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

