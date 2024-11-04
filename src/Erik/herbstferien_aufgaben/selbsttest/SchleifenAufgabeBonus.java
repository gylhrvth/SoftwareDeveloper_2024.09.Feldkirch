package Erik.herbstferien_aufgaben.selbsttest;
/*
Zähle mithilfe einer while-Schleife und einer separaten Zählvariable von 0 bis inklusive 10 und gib die Zahlen aus.
Wenn die Zahl größer als 5 ist, mach 2 Zeilenumbrüche.
 */
public class SchleifenAufgabeBonus {
    public static void main(String[] args) {
        int start = 0;
        int end = 10;
        while (start <= end) {
            if (start > 6){
                System.out.println();
                System.out.println(start);
            } else {
                System.out.println(start);
            }
            ++start;
        }
    }
}