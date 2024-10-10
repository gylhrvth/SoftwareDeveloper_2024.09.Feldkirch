package Furkan.week05;

import java.util.Arrays;


/*
1:String erstellen
2:Schleife erstellen die char-Array umkehrt.
3.Umgekehrtes Array in String umwandeln.



 */


public class Reverse {
    public static void main(String[] args) {
        String inputText= "Hallo";
        String reversedText = textReverse(inputText);
        System.out.println(reversedText);

    }

    public static String textReverse(String text) {
        char[] charArray = text.toCharArray();
        char[] reversedArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }
        return new String(reversedArray);
    }
}