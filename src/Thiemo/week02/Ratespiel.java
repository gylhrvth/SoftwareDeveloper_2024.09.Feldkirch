package Thiemo.week02;

import java.util.Random;

/*
Todo:  print text - Funktion
       Scanner (String und int) Funktion
       range 0-100 (abfrage) -Funktion
       random zahl 0-100 generieren (new Random().nextInt() Variable
       Logik (vergleich random und spilerzahl) (zu hoch oder zu niedrig) if(else)
       Logik while (boolean true or false)


*/

public class Ratespiel {
    public static void main(String[] args) {

        System.out.println("Welcome to our Quiz Game" + "\n"+ "Guess the number between 0 and 100"+ "\n");

        int random = new Random().nextInt(0,101);

    }



}
