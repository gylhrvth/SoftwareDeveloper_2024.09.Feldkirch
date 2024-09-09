package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        printchars();
        System.out.println("-------");
        repeat(10);
        System.out.println("--------");
    }

    public static void printchars() {
        System.out.println("x");
    }

    public static void repeat(int count) {
        for (int q = 1; q < count; q++) {
            System.out.print("x");
        }
        System.out.println();
    }


}
