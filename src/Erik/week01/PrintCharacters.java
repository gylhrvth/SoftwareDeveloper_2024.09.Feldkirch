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
        System.out.println("============================"); //Ende vierte Aufgabe
        printTriangle2("x ",5);


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
                System.out.print(text);
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
            for (int column = 0; column < row + 1; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
    //Aufgabe 5 Print Triangle 2
    public static void printTriangle2 (String text, int count){
        for (int row=0; row < count; row++){
            for (int column = 0; column < count-

                    row ; column++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }
    //Aufgabe 6 Print Triangle 3

}