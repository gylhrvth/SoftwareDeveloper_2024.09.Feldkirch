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

public class Ratespiel {
    public static void main(String[] args) {

//        int random = new Random().nextInt(0, 101);
//        System.out.println(random);


        Random rand = new Random();
        int random = rand.nextInt(101);
        
        
//        System.out.println(random);
        
        
        String User = "";
        User = menu("Welcome to the Quiz Game: guessing random numbers." + "\n" + "Please choose your Gamertag");
        System.out.println();
        System.out.println("Lets start  the game then " + User + "\n" + "Now try to guess the random number between 0 and 100" + "\n");




        boolean gameover = false;

        while (!gameover) {
            int playernumber = range("Choose a Number", 0, 100);
//            System.out.println("test" + playernumber);
            if (playernumber == random) {
                gameover = true;
                System.out.println("Win");

            } else if (playernumber < random - 30) {
                System.out.println("Number way too small!");
            } else if (playernumber > random + 30) {
                System.out.println("Number way too high!");
            } else if (playernumber < random) {
                System.out.println(Colors.COLORS[1] +"Number too small!" + Colors.RESET);
            } else {
                System.out.println(Colors.COLORS[4] +"Number too high!" + Colors.RESET);
            }


        }
        System.out.println(Colors.COLORS[3] + " Congratulations" +  Colors.RESET);


    }


    public static String menu(String userinfo) {

        System.out.println(userinfo);
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        return text;


    }

    public static int range(String userinfo, int minValue, int maxValue) {

        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean richtigeEingabe = false;
        // while (richtigeEingabe == false),
        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                String hilfsText = sc.nextLine();
                number = Integer.parseInt(hilfsText);
//                number = sc.nextInt();
                if (number >= minValue && number <= maxValue) {
                    richtigeEingabe = true;
                } else {
                    System.out.println("Try a number betwenn " + minValue + " and " + maxValue + "\n"/*+userinfo*/);
                }

            } catch (NumberFormatException nfe)
//            catch (InputMismatchException ime)
            {
                System.out.println("Fail! Maybe try a Number/Something else? " + /* + " \n " + nfe +ime*/ "\n"/*+userinfo*/);
//                sc.nextLine();
            }
        }
        return number;
    }


}



