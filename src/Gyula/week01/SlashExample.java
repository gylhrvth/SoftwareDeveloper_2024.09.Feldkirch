package Gyula.week01;

public class SlashExample {
    public static void main(String[] args) {
        printSlash("A ", 5, false);
        printSlash("B ", 6, true);
    }

    public static void printForwardSlash(String text, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size - row - 1; ++col){
                System.out.print("  ");
            }
            System.out.println(text);
        }
    }

    public static void printBackSlash(String text, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print("  ");
            }
            System.out.println(text);
        }
    }

    public static void printSlash(String text, int size, boolean isBackslash){
        if (isBackslash){
            printBackSlash(text, size);
        } else {
            printForwardSlash(text, size);
        }
    }
}
