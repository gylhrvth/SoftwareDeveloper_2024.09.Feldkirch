package Erik.week02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RateSpiel {
    public static Random randomGenerator = new Random();          // Random Number Generator über dem Main Block muss nur einmal definiert werden und kann überall verwendet werden
    public static Scanner sc = new Scanner(System.in);            // Scanner wird einmal über dem Main Block initialisiert und kann überall verwendet werden. Muss man nicht mehrmals neu schreiben

    public static void main(String[] args) {

        int guessingNumber = randomGenerator.nextInt(0, 5);

      //  System.out.println(guessingNumber);
        String name = readString("What's your Name?");
        System.out.println("Hello " + name + " Welcome to the Ratespiel!");
        int number = giveNumber("give me a number between 0-5", 0, 5, randomGenerator.nextInt());
        GameLogicThroughNumber("", guessingNumber);


    }

    public static String readString(String UserInfo) {
        System.out.println(UserInfo);
        String text = "";               // Unnötige Initialisierung
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        return text;
    }

    public static boolean GameLogicThroughNumber(String msg, int guessingNumber) {
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


    public static int giveNumber(String msg, int minValue, int maxValue, int guessingNumber) {

        int number = 0;
        boolean validNumber = false;

        while (validNumber == false)
            try {
                System.out.println(msg);
                number = sc.nextInt();
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






/*
        Methoden/Funktion's Tests:

        boolean test = infoThroughNumber("test", 3,3);
        System.out.println(test);

        int giveNumber = giveNumber("test", 1, 3, 2);
        System.out.println(giveNumber);

while (run == false) {
            if (run = false){
                System.out.println("give me another number");
            } else {
                System.out.println("Congratulation! You won the Game!");
                run = true;
            }

        boolean test = GameLogicThroughNumber("test", 4,3);
        System.out.println(test);
 */