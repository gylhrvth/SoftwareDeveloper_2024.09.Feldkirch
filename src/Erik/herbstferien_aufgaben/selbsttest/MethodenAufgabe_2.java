package Erik.herbstferien_aufgaben.selbsttest;

/*
Erstelle eine Methode welche einen String und einen int Parameter erhält.
Nun sollen mit diesen beiden Parametern die beiden Methoden aus den vorhergehenden Aufgaben aufgerufen werden.
Die Methoden aus den vorhergehenden Aufgaben sollen nicht neu geschrieben werden.
 */

public class MethodenAufgabe_2 {
    public static void main(String[] args) {
        Erik.herbstferien_aufgaben.selbsttest.MethodenAufgabe_1.printLineStipple("X",3);
        System.out.println();
        printStippleL("X", 3);
    }

    public static void printStippleL (String symbol, int size){
        for (int i = 0; i < size ; i++) {
            System.out.println(symbol);
            System.out.println();
        }
    }
}