package Gyula.week01;

public class SlashExampleWithIf {
    public static void main(String[] args) {
        printSlash("A ", 5, true);
        printSlash("B ", 6, false);
    }

    public static void printSlash(String text, int size, boolean isBackslash){
        if (isBackslash){
            printBackwardSlash(text, size);
        } else {
            printForwardSlash(text, size);
        }
    }


    public static void printBackwardSlash(String text, int size) {
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
                if (row + col == size - 1){
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}
