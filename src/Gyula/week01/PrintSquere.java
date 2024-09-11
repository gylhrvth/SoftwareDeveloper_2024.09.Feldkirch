package Gyula.week01;

public class PrintSquere {
    public static void main(String[] args) {
        // printChars("X", 10);
        //printSquere("X ", 4);
        printTriangleBottomLeft("A ", 5);
    }

    public static void printChars(String text, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
        System.out.println();
    }

    public static void printSquere(String text, int count){
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomLeft(String text, int count){
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                if (row >= column) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}
