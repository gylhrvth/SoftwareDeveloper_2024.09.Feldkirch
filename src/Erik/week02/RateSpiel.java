package Erik.week02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RateSpiel {
    public static void main(String[] args) {
        int number = 0;
        String name = "";

        Random rand = new Random();
        int guessingNumber = rand.nextInt(0, 5);

        System.out.println(guessingNumber);
        name = readString("What's your Name?");
        System.out.println("Hello " + name + " Welcome to the Ratespiel!");
        number = giveNumber("give me a number between 0-5", 0, 5, rand.nextInt());
        GameLogicThroughNumber("", number, guessingNumber);

//        boolean test = GameLogicThroughNumber("test", 4,3);
//        System.out.println(test);

    }

    public static String readString(String UserInfo) {
        System.out.println(UserInfo);
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        return text;
    }

    public static boolean GameLogicThroughNumber(String msg, int number, int guessingNumber) {
        Scanner sc = new Scanner(System.in);
        boolean win = false;
        int versuch = 0;
        int maxVersuche = 3;

        while (versuch < maxVersuche && win == false) {

            number = sc.nextInt();
            versuch ++;

            if (number == guessingNumber) {
                System.out.println("Congratulation! You won the Game!");
                win = true;
            } else if (number < guessingNumber) {
                System.out.println("Your guess is to low! Try higher \n" + "Give me another Number");
            } else if (number > guessingNumber) {
                System.out.println("Your guess is to high! Try lower \n" + "Give me another Number");
            }
        }

            if (win == false){
                System.out.println("You loose! \n" + "Your guessing Number would have been " + guessingNumber);
            }
        sc.close();
        return win;
    }


    public static int giveNumber(String msg, int minValue, int maxValue, int guessingNumber) {

        int number = 0;
        Scanner sc = new Scanner(System.in);
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







//        Methoden/Funktion's Tests:
//
//        boolean test = infoThroughNumber("test", 3,3);
//        System.out.println(test);
//
//        int giveNumber = giveNumber("test", 1, 3, 2);
//        System.out.println(giveNumber);
/*
while (run == false) {
            if (run = false){
                System.out.println("give me another number");
            } else {
                System.out.println("Congratulation! You won the Game!");
                run = true;
            }
 */