package Erik.week06;

/*
        Todo:   1. Mache einen String namens text mit dem Wert "data.Texts.HESSE". ♥ (den Text in ein String gespeichert für angenehmeres schreiben)
                2. Mache einen weiteren String names search mit dem Wert "Hesse". ♥ (der zu suchende Wert in meinem Text)
                3. Printe den Text aus. ♥
                4. Mach einen Print out mit der indexOf (String Methode). ♥
                5. Mach einen Int mit dem Namen "Count" (um zu zählen wie oft "Hesse" im Text vorkommt) ♥
                6. Mach einen Int mit dem Namen "index" (um die Index Position wo das Wort "Hesse" gefunden wird vorübergehend gespeichert wird)
                7. Printe aus wie oft "Hesse" im Text vorkam
                8. Printe aus an welchen Idx Stellen "Hesse" gefunden wurden.
                9. Erweiterung: (probiere mit replace und upperCase ein bisschen rum)
               10. Mach einen Print out wo das gesuchte Wort "Hesse" replaced wird un mit toUpperCase groß geschrieben wird.
               11. Erstelle einen Scanner
               12. Mach eine Methode die das selbe macht wie bei "Schritt 10" nur mit einer User Eingabe
               13. Zusatz für mich: Das eingegebene Wort vom User im Text Rot markieren.
 */
import Sandro.Colors;
import data.Texts;
import java.util.Scanner;

public class SearchForHesse {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String text = Texts.HESSE;
        String search = "Hesse";

        System.out.println(text);
        System.out.println("---");
        searchForHesseAndPrintCountAndIndex(text, search);
        System.out.println("---");
        System.out.println("Hermann Hesse Text mit 'HESSE' statt 'Hesse'" + "\n");
        System.out.println(text.replace(search, search.toUpperCase()));                 // "Hesse" wird replaced mit dem "Hesse"to.UpperCase Funktion (Ergebnis: HESSE)
        System.out.println("---");
        replaceAWordFromUserInputToUpperCase(text);
        System.out.println("---");

    }

    public static void searchForHesseAndPrintCountAndIndex(String text, String search) {
        int count = 0;
        int index = text.indexOf(search);                                                               // index wird mit dem ersten "Hesse" treffer definiert

        while (index != -1) {                                                                           // While Schleife läuft, solange bis das Wort "Hesse" nicht gefunden wird (und -1 zurückgibt)
            ++count;                                                                                    // Counter wird um 1 erhöht, weil das Wort "Hesse" außerhalb schon einmal gefunden wurde.
            System.out.println("Das Wort 'Hesse' wurde auf Index Position " + index + " gefunden");     // Print out von der aktuellen Position vom Index
            index = text.indexOf(search, index + 1);                                           // Es wird nach dem neuen Index gesucht da der "search" start um +1 verschoben wurde
        }
        System.out.println("---");
        System.out.println("Das Wort 'Hesse' wurde " + count + " mal gefunden");
    }

    public static void replaceAWordFromUserInputToUpperCase(String text) {
        System.out.println(text + "\n");
        System.out.println(" ");
        System.out.println("Gib ein Wort ein wo du im Text groß schreiben lassen willst");
        System.out.print(">> ");
        String userInput = sc.nextLine();
        System.out.println(text.replace(userInput, Colors.COLORS[1] + userInput.toUpperCase() + Colors.RESET));     // Eingegebener Text wird Rot markiert und groß, geschrieben.
    }
}
/*
        System.out.println("---");
        System.out.println("Das erste, mal wurde 'Hesse' auf Index Position: " + text.indexOf(search) + " gefunden");

        Replace und Upper Case Test
        String test = "Herman Hesse ist tot";

        System.out.println("Original: " + test);
        System.out.println("changed: " + test.replace("Hesse", "Kessler"));
        System.out.println(test.toUpperCase() + " " + test.replace("Hesse", "Kessler"));
 */