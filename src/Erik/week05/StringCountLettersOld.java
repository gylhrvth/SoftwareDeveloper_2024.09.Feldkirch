package Erik.week05;


/*
            Todo:   1. erstelle einen text mit data.Texts.getSimpleText()
                    2. gib diesen aus.
                    2. erstelle ein int [] zum zählen der buchstaben und zeichen
                    3. mit for i schleife schauen wie viel chars der gesamte text hat
                    4.
 */
public class StringCountLettersOld {
    public static void main(String[] args) {

        String text = data.Texts.getSimpleText();
        char[] letters = text.toCharArray();
        char test = ' ';
        int[] countMyChars = new int[Character.MAX_VALUE];

        for (int i = 0; i < text.length(); i++) {
            test = text.charAt(i);
            ++countMyChars[text.charAt(i)];
        }

        System.out.println(data.Texts.getSimpleText());

        data.Texts.getSimpleText().toCharArray();

        for (int i = 0; i < data.Texts.getSimpleText().length(); i++) {
//            System.out.println(i); // gibt die länge des textes an <-- 2429 chars in dem fall
        }
        int count = 0;
        System.out.println("Buchstabe 'a' kommt: " + findLetterTest() + " mal vor");

    }

    public static int findLetterTest() {
        String text = data.Texts.getSimpleText();
        char letter = 'a';
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

//    public static int findAllLetters() {
//        int[] countMyChars = new int[Character.MAX_VALUE];
//        String text = data.Texts.getSimpleText();
//        char wasBinIch = ' ';
//        for (int i = 0; i < text.length(); i++) {
//            wasBinIch = text.charAt(i);
//            ++countMyChars[text.charAt(i)];
//        }
//        return ;
//    }


}
