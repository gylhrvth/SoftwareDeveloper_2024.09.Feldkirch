package Erik.herbstferien_aufgaben.selbsttest;

import Sandro.Colors;

import java.util.Random;

/*
Es soll eine beliebige Zahl zwischen 0 und 100 mittels new Random().nextInt(...) gewählt werden.
Nun soll die Zahl durch Eingabe über die Konsole erraten werden.
Ist die Zahl zu hoch oder zu niedrig, so soll diese Information ausgegeben werden.
Wurde die Zahl getroffen, so ist das Spiel gewonnen und das Programm wird beendet.
 */
// Scanner erstellen für die Eingabe des Users zum Raten der Zahl
// Counter der die Versuche zählt max. 5 Versuche
// Game Logik:
// Random Zahl wird generiert,
// Spieler wird nach einer Zahl abgefragt,
// Spieler gibt die Zahl ein Bekommt eine Meldung zurück ob, zu hochgeschätzt oder zu niedrig
// Logik läuft, solange durch bis die Versuche aufgebraucht wurden oder die Zahl erraten wurde

public class InputAufgabe_2 {
    public static Random rand = new Random();

    public static void main(String[] args) {
        int guessingNumber = rand.nextInt(1, 101);
        System.out.println("Hello and Welcome to\n>>Guess the Number<<");
        runGame(guessingNumber);
    }

    public static void runGame(int guessingNumber) {
        boolean endGame = false;
        int tries = 0;
        // Solange endGame false ist oder tries kleiner als 5 ist läuft, das spiel weiter
        while (!endGame && tries < 5) {
            // Player eingabe abfragen mit scanner von InputAufgabe_1
            int userInput = InputAufgabe_1.checkUserInputNumber("Which Number you think it is ...\nEnter here: >> ", 1, 100);
            tries++;
            System.out.println(tries + " Try\n");

            // prüfen wie nah der spieler an der zahl war und info zurückgeben
            if (userInput < guessingNumber) {
                System.out.println("Your guess was to Low try Higher");
            } else if (userInput > guessingNumber) {
                System.out.println("Your guess was to High try Lower");
            }

            // prüfen ob endGame condition erfüllt wurde
            if (userInput == guessingNumber) {
                System.out.println(Colors.COLORS[2] + "Congratulations! You have guessed the Number" + Colors.RESET);
                endGame = true;
            } else if (tries == 5) {
                System.out.println(Colors.COLORS[1] + "You loose! Max tries reached\nThe Guessing Number was: >>" + guessingNumber + Colors.RESET);
                endGame = true;
            }
        }
    }
}