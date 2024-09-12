package Akif_Malik.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        printRhombus("x ", 7);

    }


    public static void printRhombus(String text, int count) {
        if (count % 2 == 0) {
            count--;
        }
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                if (row + count / 2 == column) {
                    System.out.print(text);
                } else if (column + count / 2 == row) {
                    System.out.print(text);
                } else if (row + column == count / 2) {
                    System.out.print(text);
                } else if (row + column - (count / 2) == count - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
