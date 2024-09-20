package Sandro.Week2;

import Sandro.Colors;

import java.util.Random;
import java.util.Scanner;

public class RateSpiel {

    public static void main(String[] args) {
        Random rand = new Random();
        int secretNumber = rand.nextInt(1, 101);

        System.out.println("Welcome to my awesome Game!!!");
        String name = readName("Please Enter your Name : ");
        String color = chooseColor("Please choose a Color");
        name = color + name + Colors.RESET;

        System.out.println("Nice to meet you " + name);
        System.out.println("Lets talk about the rules...");
        System.out.println("Guess a Number between 1 and 100.");
        System.out.println("You have 7 tries.");

        int counter = 1;
        boolean gameover = false;

        while (!gameover) {
            int playernumber = readNumber("please enter a number now", 1, 100);
            gameover = winConditoin(playernumber,secretNumber,counter,name);
            counter++;
        }


    }

    public static boolean winConditoin (int playernumber, int secretNumber, int counter, String name){
        boolean gameover = false;

        if (playernumber == secretNumber) {
            gameover = true;
            System.out.println("Congratulation " + name + " you did it, the Secretnumber was " + secretNumber);

        } else if (counter == 7) {
            System.out.println("To Bad " + name + ", you dont have any guesses left, try next time ;D");
            gameover = true;
        }

        if (playernumber < secretNumber) {
            System.out.println("your guess was to low " + name + ", try higher");
        } else if (playernumber > secretNumber) {
            System.out.println("your guess was to high " + name + ", try lower");
        }
        if (counter == 6){
            System.out.println("Achtung nur noch ein Versuch !!!");
        }

        return gameover;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String chooseColor(String msg) {
        String color = "";
        System.out.println(msg);

        System.out.printf(Colors.COLORS[1] + "1" + Colors.COLORS[2] + "2" + Colors.COLORS[3] + "3" + Colors.RESET);
        System.out.println();
        int pick = readNumberForColor("Type number for Color", 1, 3);
        if (pick == 1) {
            color = Colors.COLORS[1];
        } else if (pick == 2) {
            color = Colors.COLORS[2];
        } else if (pick == 3) {
            color = Colors.COLORS[3];
        }

        return color;
    }

    public static String readName(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String name = sc.nextLine();
        return name;
    }

    public static int readNumber(String msg, int min, int max) {             //Exception Try Catch block
        int number = 0;                                                              //Input Mismatch Exception
        Scanner sc = new Scanner(System.in);                                         //Repeat process with While
        boolean NumberIsValid = false;

        while (!NumberIsValid) {
            try {
                System.out.println(msg);
                String line = sc.nextLine();                                         //Read the input as a String!
                number = Integer.parseInt(line);                                      //Parse the String into an Integer!
                if (number >= min && number <= max) {                                 //Check if the number is in Range from min max
                    NumberIsValid = true;
                } else {
                    System.out.println("Input Number must be between " + min + " and " + max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Sorry,that was not a Valid number");
                //sc.nextLine();                                                       //dont need next.line, to read the input Try what is the difference
            }


        }
        return number;
    }

    public static int readNumberForColor(String msg, int min, int max) {             //Exception Try Catch block
        int number = 0;                                                              //Input Mismatch Exception
        Scanner sc = new Scanner(System.in);                                         //Repeat process with While
        boolean NumberIsValid = false;

        while (!NumberIsValid) {
            try {
                System.out.println(msg);
                String line = sc.nextLine();                                         //Read the input as a String!
                number = Integer.parseInt(line);                                      //Parse the String into an Integer!
                if (number >= min && number <= max) {                                 //Check if the number is in Range from min max
                    NumberIsValid = true;
                } else {
                    System.out.println("Input Number must be between " + min + " and " + max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Sorry,that was not a Valid number");
                //sc.nextLine();                                                       //dont need next.line, to read the input Try what is the difference
            }


        }
        return number;
    }
}

