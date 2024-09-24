package Erik.week03;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/*
    Todo:       1. Scanner erstellen ♥
                2. Funktion erstellen für die Float einlesung
                3. Funktion erstellen für die verschiedenen String Operatoren (+,-,*,^,/,)
                4. Funktion erstellen für die Rechenaufgabe + Ergebnis
------------------------------------------------------------------------------------------------
                1. Scanner erstellen
                2. alles im Main block zuerst machen
                   1. zwei float zahlen einlesen
                   2.
*/

public class CalculatorNew {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        giveNumbers("Gib die erste Zahl ein:");
        giveOperator("Gib den gewünschten Operator ein: +,-,*,^,/,");
        giveNumbers("Gib die zweite Zahl ein:");
        giveResult("Das Ergebnis ist: ");


    }

    public static float giveNumbers(String msg) {
        float zahl = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                System.out.println(msg);
                String text = sc.nextLine();
                zahl = Float.parseFloat(text);
                validNumber = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Gib mir eine Zahl!");
            }
        }
        return zahl;
    }

    public static String giveOperator(String msg) {
        System.out.println(msg);

        String Operator = sc.nextLine();

        if (Operator.equals("+")) {
            System.out.println("+");
        } else if (Operator.equals("-")) {
            System.out.println("-");
        } else if (Operator.equals("*")) {
            System.out.println("*");
        } else if (Operator.equals("^")) {
            System.out.println("^");
        } else if (Operator.equals("/")) {
            System.out.println("/");
        }

        return Operator;
    }

    public static float giveResult (String msg){
        float result = 0;



        return result;
    }

}
/*
            try {
                System.out.println(msg);
                zahl = sc.nextFloat();
                validNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println("Error");
            }
 */