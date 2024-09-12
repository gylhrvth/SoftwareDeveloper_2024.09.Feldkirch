package Akif_Malik.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        printRhombus("x ", 7);

    }


    public static void printRhombus(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print(text);
                } else if (col == row + size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < 2 * size - 1; column++) {
                if (row + column == size - 1) {
                    System.out.print(text);
                } else if (column == row + size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();

        }
    }
}
