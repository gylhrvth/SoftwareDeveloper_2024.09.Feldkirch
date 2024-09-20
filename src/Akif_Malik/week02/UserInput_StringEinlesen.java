package Akif_Malik.week02;

import Sandro.Colors;

import java.util.Random;
import java.util.Scanner;

public class UserInput_StringEinlesen {


    public static void main(String[] args) {
        int number = 0;
        String name;
        String place;
        int age = 0;
        String scannerInput = "";
        System.out.println(scannerInput);
        name = stringReader(Colors.COLORS[3] + "Welcome, please enter your name." + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Good Morning " + name + "!" + Colors.RESET);
        place = stringReader(Colors.COLORS[3] + "Where do you live?" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Wow, you are from " + place + Colors.RESET);
        age = ageNumber(Colors.COLORS[3] + "How old are you?" + Colors.RESET, 1, 100);
        System.out.println(Colors.COLORS[2] + "Nice, you are " + age + " years old!" + Colors.RESET);
        number = readNumbers(Colors.COLORS[3] + "Give me a number between 1 and 100" + Colors.RESET, 1, 100);
        System.out.println(Colors.COLORS[2] + "Finally!,your Number is: " + number + Colors.RESET);
        int validNumber2;
        Random rand2 = new Random();
        int secretNumber2 = rand2.nextInt(1, 101);
        System.out.println(Colors.COLORS[6] + "While you were answering my questions, I coded a game for you!" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "There is no specific rules yet but there might be later" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "Clue: " + Colors.RESET + Colors.COLORS[6] + "The number You have to guess is between 1 and 100" + Colors.RESET);
        validNumber2 = 0;
        boolean win = false;
        while (win == false) {
            Scanner sc = new Scanner(System.in);
            validNumber2 = sc.nextInt();
            if (validNumber2 < 1 && validNumber2 > 100) ;
            else if (validNumber2 < secretNumber2) {
                System.out.println(Colors.COLORS[1] + "good guess but its too low, try guessing higher" + Colors.RESET);
            } else if (validNumber2 > secretNumber2) {
                System.out.println(Colors.COLORS[1] + "good guess but its too high, try guessing lower" + Colors.RESET);
            } else if (validNumber2 == secretNumber2) {
                System.out.println(Colors.COLORS[2] + "Wow! " + name + " from " + place + " you've guessed the random number!!! Congratulations" + Colors.RESET);
                win = true;
                return;
            }
        }
    }

    public static String stringReader(String userinfo) {
        System.out.println(userinfo);
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);
        scannerInput = sc.nextLine();
        return scannerInput;
    }

    public static int readNumbers(String usertext, int minValue, int maxValue) {

        System.out.println(usertext);
        int scannerInput2 = 0;
        boolean validNumber = false;
        Scanner sc = new Scanner(System.in);

        while (!validNumber) {
            try {
                scannerInput2 = sc.nextInt();
                if (scannerInput2 >= minValue && scannerInput2 <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "do you not see!?, it MUST be between 1 and 100!!" + Colors.RESET);
                    System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                }

            } catch (Exception exp) {
                System.out.println(Colors.COLORS[1] + "bruhhh, I said a number!" + Colors.RESET);
                System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                sc.nextLine();
            }
        }
        return scannerInput2;
    }

    public static int ageNumber(String usertext, int minValue, int maxValue) {

        System.out.println(usertext);
        int scannerInput2 = 0;
        boolean validNumber = false;
        Scanner sc = new Scanner(System.in);

        while (!validNumber) {
            try {
                scannerInput2 = sc.nextInt();
                if (scannerInput2 >= minValue && scannerInput2 <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "how are you still alive?!?!" + Colors.RESET);
                    System.out.println(Colors.COLORS[1] + "stop lying!," + "now tell me your real age!!" + Colors.RESET);
                }

            } catch (Exception exp) {
                System.out.println(Colors.COLORS[1] + "do you not get the question?!" + Colors.RESET);
                System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                sc.nextLine();
            }
        }
        return scannerInput2;
    }
}
