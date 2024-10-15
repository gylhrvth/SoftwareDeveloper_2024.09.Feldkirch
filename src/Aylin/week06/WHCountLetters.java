package Aylin.week06;

public class WHCountLetters {

    public static void main(String[] args) {
        System.out.println(data.Texts.getSimpleText());
        String text = data.Texts.getSimpleText();
        printCharacters(characters(text));
    }

    public static int[] characters(String text){
        int[] datenbank = new int[Character.MAX_VALUE];
        for (int i = 0; i < text.length(); i++) {
            ++datenbank[text.charAt(i)];
        }
        return datenbank;
    }

    public static void printCharacters(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                System.out.println((char)i + ": " + arr[i]);
            }
        }
    }
}
