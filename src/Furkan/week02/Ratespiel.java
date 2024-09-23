package Furkan.week02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {

//
//        Random rand = new Random();
//        int secretNumber = rand.nextInt(1, 101);
//        secretNumber = 3;
//        Scanner sc = new Scanner(System.in);
//
//
//
//        System.out.println("Willkommen beim super coolen Zahlen Ratespiel!");
//        System.out.println("Errate die Zahl zwischen 0 und 100!");
//        secretNumber= readNumber("richtig", 100, 2 );
//
//
//
//
//    }
//
//
//    public static int readNumber(String msg, int minValue, int maxValue, int number, int secretNumber) {
//        System.out.println(msg);
//        int readNumber = 0;
//        Random rand = new Random();
//        secretNumber = rand.nextInt(1, 101);
//        Scanner sc = new Scanner(System.in);
//        boolean validNumber = false;
//
//        while (validNumber == false) {
//            try {
//                number = sc.nextInt();
//                if (number >= minValue && number <= maxValue) {
//                    validNumber = true;
//                } else {
//                    System.out.println("Die eingegebene Zahl muss zwischen " + minValue + " und " + maxValue + " sein ");
//                }
//
//                readNumber = sc.nextInt();
//                validNumber = true;
//            } catch (InputMismatchException ime) {
//                System.out.println("Du musst mir eine Zahl geben, nicht ein text!");
//                sc.nextLine();
//                System.out.println(msg);
//            }
//
//            if (number < secretNumber) {
//                System.out.println("Die Zahl ist größer.");
//            } else if (number > secretNumber) {
//                System.out.println("Die Zahl ist kleiner.");
//
//            } else {
//                System.out.println("Glückwunsch! Du hast die Zahl erraten. ");
//            }
//
//        }
//        return readNumber;


        //----------------------------------------------------------------------------------------------------------------------


//        // int Zahl = 0;
//        Random rand = new Random();
//        int secretNumber = rand.nextInt(1, 101);
//
//
//        System.out.println("Willkommen beim super coolen Zahlen Ratespiel!");
//        System.out.println("Errate die Zahl zwischen 0 und 100!");
//        secretNumber = readNumber("Gib die Zahl nun ein." );
//        System.out.println(secretNumber+ "ist richtig!");
//
//
//    }
//
//
//    public static int readNumber(String msg, int minValue, int maxValue, int number) {
//        System.out.println(msg);
//        int readNumber = 0;
//        Scanner sc = new Scanner(System.in);
//        boolean validNumber = false;
//
//        while (validNumber == false) {
//            try {
//                number = sc.nextInt();
//                if (number >= minValue && number <= maxValue) {
//                    validNumber = true;
//                } else {
//                    System.out.println("Die eingegebene Zahl muss zwischen " + minValue + " und " + maxValue + " sein ");
//                }
//
//                readNumber = sc.nextInt();
//                validNumber = true;
//            } catch (InputMismatchException ime) {
//                System.out.println("Du musst mir eine Zahl geben, nicht ein text!");
//                sc.nextLine();
//                System.out.println(msg);
//            }
//        }
//
//        return readNumber;
//    }


    }
}

