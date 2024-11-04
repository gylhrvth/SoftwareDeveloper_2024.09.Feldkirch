package Erik.herbstferien_aufgaben.selbsttest;

import Sandro.Colors;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Lies einen String vom Benutzer ein (ganze Zeile) und einen int.
Die Zahl besagt wie oft der String ausgegeben werden soll.
Wird ein leerer String oder eine ungültiger int eingegeben, so soll die Eingabe erneut erfolgen.
 */

public class InputAufgabe_1 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String text = checkUserInputText("Please enter some text:\n>> ");
        int repeat = checkUserInputNumber("How often do you want to print it?\n>> ", 1, 100);
        printUserInput(text, repeat);
    }
    // Gyula Safe | Check Zahlen Eingabe vom User
    public static int checkUserInputNumber(String userInfo, int minValue, int maxValue) {
        boolean validNumber = false;
        int userInput = 0;
        while (!validNumber) {
            try {
                System.out.println("Choose between " + minValue + " and " + maxValue);
                System.out.print(userInfo);
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "Entered Number is out of Range" + Colors.RESET);
                }
            } catch (InputMismatchException ime) {
                System.out.println(Colors.COLORS[1] + "Enter a valid Number!" + Colors.RESET);
            }
            sc.nextLine();
        }
        return userInput;
    }

    // Gyula Safe | Check Text Eingabe vom User | Probleme if/else bei is.Blank richtig zu definieren Hilfe geholt aus sandro week02 Rehearsal Donnerstag
    public static String checkUserInputText(String userInfo) {
        boolean validText = false;
        String userInput = "";

        while (!validText && userInput.isBlank()) {
            try {
                System.out.print(userInfo);
                userInput = sc.nextLine();
                if (!userInput.isBlank()) {
                    validText = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "Error! Enter Text!" + Colors.RESET);
                }
            } catch (Exception ex) {
                System.out.println("Enter some Text!");
            }
        }
        return userInput;
    }

    public static void printUserInput(String text, int repeat){
        for (int i = 0; i < repeat ; i++) {
            System.out.println(text);
        }
    }
}
