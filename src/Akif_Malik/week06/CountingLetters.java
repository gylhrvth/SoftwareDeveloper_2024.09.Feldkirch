package Akif_Malik.week06;

/*
            Todo: 1. text abholen
                  2.
                  3.

 */

public class CountingLetters {
    public static void main(String[] args) {
        String text = data.Texts.getSimpleText();
        System.out.println(text);
        createArray(countLetter(text));
    }

    public static void createArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 ){
                System.out.printf("%-5c ---> %5d- %3d", (char)i, i, arr[i]);
                System.out.println();
            }
        }
    }

    public static int[] countLetter(String text) {
        int[] count = new int[Character.MAX_VALUE];
        for (int i = 0; i < text.length(); i++) {
            ++count[text.charAt(i)];
        }
        return count;
    }
}
