package Akif_Malik.week01;

public class PrintTriangle6 {
    public static void main(String[] args) {
        printTriangle("x ", 8);

    }

    public static void printTriangle(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print(text);
                } else if (col == row + size - 1) {
                    System.out.print(text);
                } else if (row == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}
