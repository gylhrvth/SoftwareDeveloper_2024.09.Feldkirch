package Akif_Malik.week02;

import Sandro.Colors;

import java.util.Scanner;

public class UserInput_StringEinlesen {


    public static void main(String[] args) {
        int zahl = 0;
        String name;
        String ort;
        int alter = 0;
        String scannerInput = "";
        System.out.println(scannerInput);
        name = stringReader(Colors.COLORS[3] + "Welcome, please enter your name." + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Good Morning " + name + "!" + Colors.RESET);
        ort = stringReader(Colors.COLORS[3] + "Where do you live?" + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Wow, you are from " + ort + Colors.RESET);
        alter = ageNumber(Colors.COLORS[3] + "How old are you?" + Colors.RESET, 1, 100);
        System.out.println(Colors.COLORS[2] + "Nice, you are " + alter + " years old!" + Colors.RESET);
        zahl = readNumbers(Colors.COLORS[3] + "Give me a number between 1 and 100" + Colors.RESET, 1, 100);
        System.out.println(Colors.COLORS[2] + "Well Done!,your Number is: " + zahl + Colors.RESET);

    }

    public static String stringReader(String userinfo) {
        System.out.println(userinfo);
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);
        scannerInput = sc.nextLine();
        return scannerInput;
    }

    public static int readNumbers(String usertext, int minValue, int maxValue) {

        System.out.println(usertext);
        int scannerInput2 = 0;
        boolean validNumber = false;
        Scanner sc = new Scanner(System.in);

        while (validNumber == false) {
            try {
                scannerInput2 = sc.nextInt();
                //System.out.println(usertext);
                //String tempText = sc.nextLine();
                //scannerInput2 = Integer.parseInt(tempText);
                if (scannerInput2 >= minValue && scannerInput2 <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "do you not see!?, it MUST be between 1 and 100!!" + Colors.RESET);
                    System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                }

            } catch (Exception exp) {
                System.out.println(Colors.COLORS[1] + "bruhhh, I said a number!" + Colors.RESET);
                System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                sc.nextLine();
            }
        }
        return scannerInput2;
    }

    public static int ageNumber(String usertext, int minValue, int maxValue) {

        System.out.println(usertext);
        int scannerInput2 = 0;
        boolean validNumber = false;
        Scanner sc = new Scanner(System.in);

        while (validNumber == false) {
            try {
                scannerInput2 = sc.nextInt();
                //System.out.println(usertext);
                //String tempText = sc.nextLine();
                //scannerInput2 = Integer.parseInt(tempText);
                if (scannerInput2 >= minValue && scannerInput2 <= maxValue) {
                    validNumber = true;
                } else {
                    System.out.println(Colors.COLORS[1] + "how are you still alive?!?!" + Colors.RESET);
                    System.out.println(Colors.COLORS[1] + "stop lying!," + "now tell me your real age!!" + Colors.RESET);
                }

            } catch (Exception exp) {
                System.out.println(Colors.COLORS[1] + "do you not get the question?!" + Colors.RESET);
                System.out.println(Colors.COLORS[1] + "try again!" + Colors.RESET);
                sc.nextLine();
            }
        }
        return scannerInput2;
    }
}
