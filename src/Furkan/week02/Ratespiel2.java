package Furkan.week02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ratespiel2 {
    public static void main(String[] args) {
        int randomNumber = randomNumber();
        String name = readString("Gib deinen Namen ein.");
        System.out.println("Hallo " + name + " ,viel Spaß beim spielen.");
        int count = 0;
        boolean gameover = false;

        while (!gameover) {
            int playerNumber = readNumber("Errate die zahl zwischen 0 und 100", 0, 100);

            if (playerNumber == randomNumber) {
                System.out.println("gewonnen");
                gameover = true;
            } else if (playerNumber > randomNumber) {
                System.out.println("Die zahl war zu groß");

            } else if (playerNumber < randomNumber) {
                System.out.println("Die zahl war zu klein");
            }


            count++;

            System.out.println("count ist = "+ count);





        }

    }

    public static String readString(String msg) {
        System.out.println(msg);
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);

        scannerInput = sc.nextLine();
        return scannerInput;
    }

    public static int readNumber(String msg, int minValue, int maxValue) {

        int readNumber = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (validNumber == false) {
            try {
                System.out.println(msg);
                readNumber = sc.nextInt();
                sc.nextLine();                          //sc.nextInt ist diese Line notwendig !!!
                if (readNumber >= minValue && readNumber <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println("Input Number must be between " + minValue + " and " + maxValue);
                }
            } catch (InputMismatchException ime) {
                // System.out.println("Hey, da ist was schief gelaufen!");
                // System.out.println("Der fehler war = " + ime);
                System.out.println("Du musst mir eine zahl geben, nicht text!");
                sc.nextLine();                            //sc.nextInt ist diese Line notwendig !!!
            }

        }
        return readNumber;
    }

    public static int randomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(0, 100);
        return randomNumber;


    }
}
