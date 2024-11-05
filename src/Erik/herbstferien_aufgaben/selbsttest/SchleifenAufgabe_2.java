package Erik.herbstferien_aufgaben.selbsttest;

// Zähle in einer for-Schleife von -30 bis inklusive 30 und gib jede Zahl aus die ohne Rest durch 3 teilbar ist.

public class SchleifenAufgabe_2 {
    public static void main(String[] args) {
// if i % 3 == 0 für, was die 0?
        for (int i = -30; i <= 30 ; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}