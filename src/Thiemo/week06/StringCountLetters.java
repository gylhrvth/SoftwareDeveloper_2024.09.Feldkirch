package Thiemo.week06;

public class StringCountLetters {

    public static void main(String[] args) {
        String text = data.Texts.getSimpleText();
        System.out.println(text);
        printCharacters(characters(text));
    }

    public static int[] characters(String text) {
        int[] count = new int[Character.MAX_VALUE];
        for (int i = 0; i < text.length(); i++) {
            ++count[text.charAt(i)];
        }
        return count;
    }

    public static void printCharacters(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.printf("%-5c ---> %5d - %5d", (char)i, i, arr[i]);
                System.out.println();
            }
        }
    }
}

