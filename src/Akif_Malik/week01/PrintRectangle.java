package Akif_Malik.week01;

public class PrintRectangle {
    public static void main(String[] args) {
        printRect("x ", 10, 3);


    }

    public static void printRect(String text, int columns, int lines) {
        for (int i = 0; i <= lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
