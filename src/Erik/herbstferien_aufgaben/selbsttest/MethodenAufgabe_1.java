package Erik.herbstferien_aufgaben.selbsttest;

/*
Erstelle eine Methode welche einen String und einen int Parameter erhält. ♥
Der angegebene String soll so oft wie beim int angegeben,
in einer Zeile wiederholt ausgegeben und mit einem Whitespace getrennt werden.
 */

public class MethodenAufgabe_1 {
    public static void main(String[] args) {
        printLineStipple("X", 10);
    }

    public static void printLineStipple(String symbol, int size) {
        for (int i = 0; i < size ; i++) {
            System.out.print(symbol + " ");
        }
    }
}