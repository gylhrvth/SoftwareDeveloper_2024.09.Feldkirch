package Akif_Malik.week02;

import Sandro.Colors;

import java.util.Random;
import java.util.Scanner;

public class UserInput_GuessingGame_Test {
    public static void main(String[] args) {

        int validNumber2;
        Random rand = new Random();
        int secretNumber = rand.nextInt(1, 101);
        System.out.println(Colors.COLORS[6] + "While you were answering my questions, I coded a game for you!" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "There is no specific rules yet but there might be later" + Colors.RESET);
        System.out.println(Colors.COLORS[5] + "Clue: " + Colors.RESET + Colors.COLORS[6] + "The number You have to guess is between 1 and 100" + Colors.RESET);
        validNumber2 = 0;
        boolean win = false;
        while (win == false) {
            Scanner sc = new Scanner(System.in);
            validNumber2 = sc.nextInt();
            if (validNumber2 < 1 && validNumber2 > 100) ;
            else if (validNumber2 < secretNumber) {
                System.out.println(Colors.COLORS[1] + "good guess but its too low, try guessing higher" +  Colors.RESET);
            } else if (validNumber2 > secretNumber) {
                System.out.println(Colors.COLORS[1] + "good guess but its too high, try guessing lower" + Colors.RESET);
            } else if (validNumber2 == secretNumber) {
                System.out.println(Colors.COLORS[2] + "Wow!, you've guessed the random number!!! Congratulations" + Colors.RESET);
                win = true;
            }



        }

    }

}
