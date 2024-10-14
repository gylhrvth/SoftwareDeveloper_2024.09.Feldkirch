package Erik.week05;

/*
            Todo:   1. data.Texts.getSimpleText() ausgeben.
                    2. int [] erstellen mit größe Character max Value (schublade für jeden einzelnen Character erstellt)
                    3. for i um den text durchzugehen
                    4. text in toChar[] umwandeln
                    5. Print funktion erstellen zum ausgeben der einzelnen Zeichen
 */


public class StringCountLetters2 {
    public static void main(String[] args) {

        String text = data.Texts.getSimpleText();
        int[] countLetters = new int[Character.MAX_VALUE];
        char[] wholeText = text.toCharArray();

        System.out.println(wholeText);

        for (int i = 0; i < wholeText.length; i++) {
            ++countLetters[wholeText[i]];
        }

        for (int i = 0; i < countLetters.length; i++) {
            if (countLetters[i] > 0) {
                System.out.println("Character: " + (char) i + " Count: " + countLetters[i]);
            }

        }
    }
}
