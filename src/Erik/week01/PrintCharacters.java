package Erik.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        printChars("x", 10);
        System.out.println(" ");
        System.out.println("=============");
        printSquare("x", 10);
    }

    public static void printChars(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
    }

    public static void printSquare(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(text);
            System.out.println(" ");

        }
    }
}


