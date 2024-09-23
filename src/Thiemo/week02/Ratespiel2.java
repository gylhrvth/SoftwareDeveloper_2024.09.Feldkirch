package Thiemo.week02;

import java.util.Random;
import java.util.Scanner;

    /*
Todo:  print text - Funktion
       Scanner (String und int) Funktion
       range 0-100 (abfrage) -Funktion
       random zahl 0-100 generieren (new Random().nextInt() Variable
       Logik (vergleich random und spilerzahl) (zu hoch oder zu niedrig) if(else)
       Logik while (boolean true or false)
       different modes ( easy (as many as you need),normal (10),hard (5),hell (2)(how many tries)
       print counter how many tries are left
       if playernumber is +30 or -30 within range of random number (with colors or print?)
       1-4 spieler? (playing against each other or playing together?)(who guesses it first?)
       range selber aussuchen







*/

public class Ratespiel2 {

    public static void main(String[] args) {
        Random rand = new Random();
        int random = rand.nextInt(101); // Random number between 0 and 100

        // User selects gamertag
        String user = menu("Welcome to the Quiz Game: guessing random numbers.\nPlease choose your Gamertag");
        System.out.println("\nLet's start the game, " + user + "!\nNow try to guess the random number between 0 and 100.\n");

        // Select difficulty level
        System.out.println("Select difficulty level:");
        System.out.println("1. Easy (10 tries)");
        System.out.println("2. Medium (7 tries)");
        System.out.println("3. Hard (5 tries)");
        System.out.println("4. Extreme (3 tries)");
        int difficulty = range("Enter difficulty (1-4): ", 1, 4);

        int maxTries = 0;
        if (difficulty == 1) {
            maxTries = 10;
        } else if (difficulty == 2) {
            maxTries = 7;
        } else if (difficulty == 3) {
            maxTries = 5;
        } else if (difficulty == 4) {
            maxTries = 3;
        }
        System.out.println("You have " + maxTries + " attempts to guess the number.\n");

        boolean gameover = false;
        int attemptsLeft = maxTries; // Initialize attempts

        // Main game loop
        while (!gameover && attemptsLeft > 0) {
            int playernumber = range("Choose a Number", 0, 100);
            attemptsLeft--; // Decrease number of attempts after each guess

            if (playernumber == random) {
                gameover = true;
                System.out.println(Colors.COLORS[2] + "Win! You've guessed the correct number!" + Colors.RESET);
            } else if (playernumber < random - 30) {
                System.out.println("Number way too small!");
            } else if (playernumber > random + 30) {
                System.out.println("Number way too high!");
            } else if (playernumber < random) {
                System.out.println(Colors.COLORS[1] +"Number too small!" + Colors.RESET);
            } else {
                System.out.println(Colors.COLORS[4] +"Number too high!" + Colors.RESET);
            }

            // If out of attempts
            if (attemptsLeft > 0 && !gameover) {
                System.out.println("Attempts left: " + attemptsLeft + "\n");
            } else if (attemptsLeft == 0 && !gameover) {
                System.out.println(Colors.COLORS[3] + "Game over! You've run out of attempts. The correct number was " + random + "." + Colors.RESET);
            }
        }

        // Winning message
        if (gameover) {
            System.out.println(Colors.COLORS[3] + " Congratulations, " + user + "!" + Colors.RESET);
        }
    }

    // Method to prompt user for Gamertag
    public static String menu(String userinfo) {
        System.out.println(userinfo);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    // Method to input and validate number within a range
    public static int range(String userinfo, int minValue, int maxValue) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean richtigeEingabe = false;

        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                number = Integer.parseInt(sc.nextLine());
                if (number >= minValue && number <= maxValue) {
                    richtigeEingabe = true;
                } else {
                    System.out.println("Try a number between " + minValue + " and " + maxValue + "\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Fail! Please try a valid number.\n");
            }
        }
        return number;
    }
}



