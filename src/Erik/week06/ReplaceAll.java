package Erik.week06;
/*
        Todo:   1. Erstelle einen String namens "text" mit dem Text der in der Aufgabenstellung ist.
                2. Erstelle für jeden einzelnes Wort ein String zur abkürzung. (muss man nicht)
                3. Printe einmal den Text aus der "wird" durch "war" ersetzt.
                4. Printe einmal den Text aus der "wird" durch "und" ersetzt.
                5. Printe einmal den Text aus der "wird" durch "ist" ersetzt.
                6. Farbe hinzufügen dass man weiß was sich geändert hat in der ausgabe. (muss man nicht)
 */
import Sandro.Colors;

public class ReplaceAll {
    public static void main(String[] args) {
        String text = "Heute wird ein guter Tag! Heute wird ein noch guterer Tag! Heute wird ein spitzen guter Tag!";
        String orgText = "wird";
        String replace1 = "war";
        String replace2 = "und";
        String replace3 = "ist";

        System.out.println(text);
        System.out.println("---");
        System.out.println(text.replace(orgText,Colors.COLORS[1] + replace1 + Colors.RESET));
        System.out.println("---");
        System.out.println(text.replace(orgText, Colors.COLORS[2] + replace2 + Colors.RESET));
        System.out.println("---");
        System.out.println(text.replace(orgText,Colors.COLORS[3] + replace3 + Colors.RESET));
    }
}
