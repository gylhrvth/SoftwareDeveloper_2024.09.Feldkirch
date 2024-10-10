package Erik.week05;

/*
            Todo:   1. Scanner erstellen
                    2. User Input abfragen
                    3. mit text.toCharArray aufsplitten
                    4. new String(charArray) zum zusammenfügen
                    5. Dann aufgesplitteter und wieder zusammengefügter String ausgeben
                    3. Irgendwie umdrehen mit (replaceAll?)
                    4. umgedrehter user input mit text.toCharArray ausgeben

 */

import java.util.Scanner;

public class StringReverse2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Gib ein beliebiges Wort ein:");
        System.out.print(">> ");
        String userInput = sc.nextLine();
        ReverseUserInput(userInput);


    }

    public static void ReverseUserInput(String userInput ){
        char[] charArr = userInput.toCharArray();

        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i]=temp;
        }

        String reversedUserInput = new String(charArr);

        System.out.println(reversedUserInput);

    }

}
