package Aylin.week02;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberVol2 {
    public static void main(String[] args) {
        int minValue = 0;
        int maxValue = 100;
        String name = "";

        System.out.println("Welcome to the ultimate guessing adventure! \nGuess the number between " + minValue + " and " + maxValue + " !");
        name = greeting("Please Enter your Name: ");
        System.out.println("Hello " + name + ". Let the game begin!");
        theGame(5);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String greeting (String userGreeting){
        System.out.print(userGreeting);
        String userInput = "";
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
        return userInput;
    }

    public static void theGame(int count){
        clearScreen();
        System.out.println();
       int randomNumber = randomNumber(0, 101);
       boolean win = false;
       boolean triesLeft = true;
       int tries = count;


       while(!win && triesLeft){
           clearScreen();
           System.out.println("Tries left: " + tries);
           int playerNumber = readNumber("Enter a Number: ", 0, 100);
           win = trueOrFalse(playerNumber, randomNumber);
           tries--;
           triesLeft = hasTriesLeft(tries);
        }
    }

    public static int readNumber(String userInput, int minValue, int maxValue){
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (!validNumber){
            try{
                System.out.println(userInput);
                String tempText = sc.nextLine();
                number = Integer.parseInt(tempText);
                if(number >= minValue && number <= maxValue ){
                    validNumber = true;
                }else{
                    System.out.println("Input Number must be between " + minValue + "and " + maxValue);
                }
            }catch(NumberFormatException nfe) {
                System.out.print("Something went wrong. " + nfe + "\n" + userInput);
            }
        }
        return number;
    }

    public static int randomNumber(int min, int max){
        int random = new Random().nextInt(min, max);
        return random;
    }

    public static boolean trueOrFalse(int playerNumber, int randomNumber){
        boolean win = false;

        if(playerNumber == randomNumber){
            System.out.println("Player wins!");
            win = true;
        }else if(playerNumber < randomNumber){
            System.out.println("Your number is too low.");
        }else{
            System.out.println("Your number is too high.");
        }
        return win;
    }

    public static boolean hasTriesLeft(int tries){
        boolean triesLeft = true;

        if(tries == 0){
            triesLeft = false;
            System.out.println("Sorry. you lost. No tries left!");
        }
        return triesLeft;
    }

}
