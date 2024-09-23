package Erik.week03;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RateSpiel_Edited {
    public static Random randomGenerator = new Random();          // Random Number Generator über dem Main Block muss nur einmal definiert werden und kann überall verwendet werden
    public static Scanner sc = new Scanner(System.in);            // Scanner wird einmal über dem Main Block initialisiert und kann überall verwendet werden. Muss man nicht mehrmals neu schreiben

    public static void main(String[] args) {

        int minValue = 0;
        int maxValue = 100;
        int guessingNumber = randomGenerator.nextInt(minValue, maxValue);

        String name = readString("What's your Name?");
        System.out.println("Hello " + name + " Welcome to the Ratespiel!");
        int number = giveNumber(minValue, maxValue);
        GameLogicThroughNumber(guessingNumber);
    }

    public static String readString(String UserInfo) {
        System.out.println(UserInfo);
        return sc.nextLine();
    }

    public static boolean GameLogicThroughNumber(int guessingNumber) {
        boolean win = false;
        int versuch = 0;
        int maxVersuche = 3;

        while (versuch < maxVersuche && !win) {

            int number = sc.nextInt();
            versuch++;

            if (number == guessingNumber) {
                win = true;
            } else if (number < guessingNumber) {
                System.out.println("Your guess is to low! Try higher \n" + "Give me another Number");
            } else if (number > guessingNumber) {
                System.out.println("Your guess is to high! Try lower \n" + "Give me another Number");
            }
        }

        if (!win) {
            System.out.println("You loose! \n" + "Your guessing Number would have been " + guessingNumber);
        } else {
            System.out.println("Congratulation! You won the Game!");
        }

        return win;
    }

    public static int giveNumber(int minValue, int maxValue) {

        int number = 0;
        boolean validNumber = false;

        while (!validNumber)
            try {
                System.out.println("Give me a Number between " + minValue + " - " + maxValue);
                number = sc.nextInt();
                sc.nextLine();

                if (number >= minValue && number <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println("Out of range");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error! Initiating Brain.Exe");
                sc.nextLine();
            }

        return number;
    }
}