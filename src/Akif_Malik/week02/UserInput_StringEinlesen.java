package Akif_Malik.week02;

import Sandro.Colors;

import java.util.Random;
import java.util.Scanner;

public class UserInput_StringEinlesen {
    public static Scanner sc2 = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        String name = stringReader(Colors.COLORS[3] + "Welcome, please enter your name." + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Good Morning " + name + "!" + Colors.RESET);
        String place = stringReader(Colors.COLORS[3] + "Where do you live?" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Wow, you are from " + place + Colors.RESET);
        int age = readNumbers(Colors.COLORS[3] + "How old are you?" + Colors.RESET,
                Colors.COLORS[1] + "how are you still alive?!?!" + Colors.RESET,
                1,
                100);
        System.out.println(Colors.COLORS[2] + "Nice, you are " + age + " years old!" + Colors.RESET);
        int number = readNumbers(Colors.COLORS[3] + "Give me a number between 1 and 100" + Colors.RESET,
                Colors.COLORS[1] + "do you not see!?, it MUST be between 1 and 100!!" + Colors.RESET,
                1,
                100);
        System.out.println(Colors.COLORS[2] + "Finally!,your Number is: " + number + Colors.RESET);

        System.out.println("\n\n");

        int validNumber2;
        Random rand = new Random();
        int secretNumber = rand.nextInt(1, 101);
        System.out.println(Colors.COLORS[6] + "While you were answering my questions, I coded a game for you!" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "There is no specific rules yet but there might be later" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "Clue: " + Colors.RESET + Colors.COLORS[6] + "The number You have to guess is between 1 and 100" + Colors.RESET);
        boolean win = false;
        while (win == false) {
            validNumber2 = readNumbers("give your guess", "you have to enter a number between 1 and 100", 1, 100);
            if (validNumber2 < secretNumber) {
                System.out.println(Colors.COLORS[1] + "good guess but its too low, try guessing higher" + Colors.RESET);
            } else if (validNumber2 > secretNumber) {
                System.out.println(Colors.COLORS[1] + "good guess but its too high, try guessing lower" + Colors.RESET);
            } else if (validNumber2 == secretNumber) {
                System.out.println(Colors.COLORS[2] + "Wow! " + name + " from " + place + " you've guessed the random number!!! Congratulations" + Colors.RESET);
                win = true;
            }
        }
    }

    public static String stringReader(String userinfo) {
        System.out.println(userinfo);
        return sc2.nextLine();
    }

    public static int readNumbers(String usertext, String replytext, int minValue, int maxValue) {

        System.out.println(usertext);
        int scannerInput2 = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                scannerInput2 = sc2.nextInt();
                if (scannerInput2 >= minValue && scannerInput2 <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(replytext);
                    System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                }

            } catch (Exception exp) {
                System.out.println(Colors.COLORS[1] + "bruhhh, I said a number!" + Colors.RESET);
                System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                sc2.nextLine();
            }
        }
        return scannerInput2;
    }


}
