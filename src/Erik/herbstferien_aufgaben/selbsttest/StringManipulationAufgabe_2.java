package Erik.herbstferien_aufgaben.selbsttest;

/*
Es soll ein Wort über die Kommandozeile eingelesen werden, dieses Wort soll umgedreht und anschließend ausgegeben werden.
Verwende hierfür text.toCharArray() für das Aufsplitten und new String(charArray) zum Zusammenfügen.
 */

import java.util.Scanner;

public class StringManipulationAufgabe_2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Scanner erstellen
        // User abfragen
        // eingegebens Wort wird in CharArray umgewandelt mit .toCharArray()
        // Alle buchstaben haben jetzt einen eignen index im Array
        // methode zum input reversen
        // for i schleife um Charr durchzugehen
        // solange wie array lang ist
        // so wie bubblesort die einzelnen buchstaben tauschen

        System.out.println("Hello!");
        System.out.print("Please Enter something you want to see reversed:\n>> ");
        String userInput = sc.nextLine();
        char[] text = userInput.toCharArray();
        reverseText(text);
        System.out.print("The entered text reversed is:\n>> " + text);


    }

    // Probleme: Wie tausche ich mein Text richtig? Nachgeschaut Week05 Reverse2
    public static String reverseText(char[] text) {
        for (int i = 0; i < text.length / 2 ; i++) {
            char temp = text[i];
            text[i] = text[text.length - 1 - i];
            text[text.length - 1 - i] = temp;
        }
        return new String(text); // Verkürzt
    }

}
/*
Erster Anlauf mit Rumspielerei von /2 weil das noch im kopf hängengeblieben ist
        for (int i = 0; i < text.length - 1; i++) { // geht durchs array so oft wie j -1 wegen out of bounce
            for (int j = 0; j < text.length /2 -1; j++) {
                if (text[j] < text[j + 1]) {
                    char temp = text[j];
                    text[j] = text[j + 1];
                    text[j + 1] = temp;
                }
            }
        }
 */