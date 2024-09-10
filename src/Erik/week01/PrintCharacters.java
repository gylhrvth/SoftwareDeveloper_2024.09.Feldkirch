package Erik.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        printChars("x ", 10);
        System.out.println();
        System.out.println("============================"); //Ende erste Aufgabe
        printSquare("x", 10);
        System.out.println("============================"); //Ende zweite Aufgabe
        printRectangle("A ", 10, 3);
        System.out.println("============================"); //Ende dritte Aufgabe
        printTrinangle1("X ", 4);



    }

    //Aufgabe 1 Print Characters
    public static void printChars(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
    }

    //Aufgabe 2 Print Square
    public static void printSquare(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int i = 0; i < count; i++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

    //Aufgabe 3 Print Rectangle
    public static void printRectangle(String text, int countColumns, int countRows) {
        for (int row = 0; row < countRows; row++) {
            for (int col = 0; col < countColumns; col++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 4 Print Trinangle 1
    public static void printTrinangle1(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int i = 4; i < count; i++) {
                System.out.print("x ");
            }
            System.out.println();
        }


    }
}
