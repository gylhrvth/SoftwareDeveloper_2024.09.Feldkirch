package Furkan.week02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringEinlesen2 {
    public static void main(String[] args) {
        String name = "";
        String ort = "";
        int alter = 0;
        int number = 0;


        System.out.println("Herzlich Wilkommen, bitte gib deinen Namen ein.");
        name = readString();
        System.out.println("Guten Tag " + name + "!");
        System.out.println("Wo wohnst du?");
        ort = readString();
        System.out.println("Du bist also von " + ort);
        alter = readNumber("Wie alt bist du?",1,100,0 );
        System.out.println(alter+"?" +"Du bist noch jung und frisch :D !");
        System.out.println();


    }

    public static String readString() {
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);

        scannerInput = sc.nextLine();
        return scannerInput;
    }

    public static int readNumber(String msg, int minValue, int maxValue, int number) {
        System.out.println(msg);
        int readNumber = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;
        //boolean minValue = false;

        while (validNumber == false) {
            try {
                number = sc.nextInt();
                //sc.nextLine();
                if (number >= minValue && number <=maxValue) {
                    validNumber = true;
                }else {
                    System.out.println("Input Number must be between " + minValue + " and " + maxValue);
                }

                    readNumber = sc.nextInt();
               // }
                validNumber = true;
            } catch (InputMismatchException ime) {
                // System.out.println("Hey, da ist was schief gelaufen!");
                // System.out.println("Der fehler war = " + ime);
                System.out.println("Du musst mir eine zahl geben, nicht text!");
                sc.nextLine();
                System.out.println(msg);
            }


        }
        return readNumber;
//        if (alter.equals("6")) {
//            System.out.println("* Richtig!");
//            return readNumber;
//        } else {
//            System.out.println("*Falsch!");
//            return
        //   return readNumber;

    }
}
//    }

