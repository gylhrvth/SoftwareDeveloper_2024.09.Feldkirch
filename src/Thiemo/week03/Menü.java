package Thiemo.week03;


import java.util.Random;
import java.util.Scanner;

public class Menü {
    public static Random randomGenerator = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to my Drawings \n" +
                " What do you want to draw?\n" +
                " 1 = XmassTree \n" +
                " 2 = Quader \n" +
                " 3 = Rhombus\n" +
                " 4 = Random");


        boolean keepDrawing = true;

        while (keepDrawing) {
            int userNumber = userInput("Choose between these numbers", 1, 4);
            if (userNumber == 4) {
                Random rand = new Random();
                userNumber = rand.nextInt(3) + 1;
                System.out.println("Random choice: " + userNumber);
            }
            if (userNumber == 1) {
                menuXmass();
            } else if (userNumber == 2) {
                menuQuader();
            } else if (userNumber == 3) {
                menuRhombus();
            }
            keepDrawing = askToDrawAgain();
        }
        System.out.println("Auf Wiedersehen!");

    }


    public static void menuXmass() {
        int number = userInput("How big you want it", 0, 100);
        Thiemo.week01.christmastree3.christmastree(number);

    }

    public static void menuQuader() {
        int number = userInput("How big you want it", 0, 100);
        String text = readText("Which symbol you want?");
        Thiemo.week01.emptysquare.EmptySquareX(text, number);
    }

    public static void menuRhombus() {
        int number = userInput("How big you want it", 0, 100);
        String text = readText("Which symbol you want?");
        Thiemo.week01.rhombus.printrhombus(text, number);
    }

    public static int userInput(String userinfo, int minValue, int maxValue) {
        int number = 0;
        boolean richtigeEingabe = false;

        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                number = Integer.parseInt(sc.nextLine());
                if (number >= minValue && number <= maxValue) {
                    richtigeEingabe = true;
                } else {
                    System.out.println("The number should be between " + minValue + " and " + maxValue + "\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error! Please try a valid number.\n");
            }
        }
        return number;


    }

    public static String readText(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public static boolean askToDrawAgain() {
        System.out.println("Want to draw something else? (y/n)");
        String response = sc.nextLine();

        if (response.equals("Y") || response.equals("y")) {
            return true;
        } else if (response.equals("N") || response.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'j' for yes or 'n' for no.");
            return askToDrawAgain();

        }
    }
}


