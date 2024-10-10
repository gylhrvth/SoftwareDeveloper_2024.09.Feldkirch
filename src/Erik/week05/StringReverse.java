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

public class StringReverse {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Gib ein Wort ein:");
        System.out.print(">> ");
        String userInput = "";
        userInput = sc.nextLine();

        String reversed = new StringBuilder(userInput).reverse().toString();

        System.out.println(reversed);
    }



}
