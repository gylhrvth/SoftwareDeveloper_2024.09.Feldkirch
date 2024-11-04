package Erik.herbstferien_aufgaben.selbsttest;

/*
Erstelle eine Methode welche einen Rhombus von variabler Größe und mit angegebene Zeichen ausgibt.
Die Größe soll dabei die Höhe des Rhombus sein.

Löse das Problem wie es dir gefällt
Löse das Problem mit nur zwei ineinander verschachtelten Schleifen
 */
public class MethodenAufgabeBonus {
    public static void main(String[] args) {
        printRhombus("x", 7);
    }

    public static void printRhombus(String symbol, int size) {
        for (int row = 0; row < size * 2 - 1; row++) {
            for (int col = 0; col < size * 2 - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print(symbol);
                } else if (row - col == size - 1) {
                    System.out.print(symbol);
                } else if (row + col == size * 3 - 3) {
                    System.out.print(symbol);
                } else if (col - row == size - 1) {
                    System.out.print(symbol);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
