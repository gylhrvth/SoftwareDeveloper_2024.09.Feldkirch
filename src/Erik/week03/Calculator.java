package Erik.week03;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Todo:       1. Scanner erstellen ♥
                2. Funktion erstellen für die Float einlesung
                3. Funktion erstellen für die verschiedenen String Operatoren (+,-,*,^,/,)
                4. Funktion erstellen für die Rechenaufgabe + Ergebnis

*/
public class Calculator {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        float number1 = readFloatFromConsole("Bitte den ersten Zahl eingeben!");
        String operator = readOperatorFromConsole("Welchen Operator willst du verwenden? (+, -, *, /, ^) ");
        float number2 = readFloatFromConsole("Bitte den zweiten Zahl eingeben!");
        float result = calculate(number1, number2, operator);

        System.out.println(result);
    }


    public static float calculate(float num1, float num2, String operator){
        float result = 0f;

        if (operator.equals("+")){
            result = num1 + num2;
        } else if (operator.equals("-")){
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        }

        return result;
    }

    public static String readOperatorFromConsole(String msg){
        String operator = "";
        boolean validOperator = false;

        while (!validOperator){
            System.out.println(msg);
            operator = sc.nextLine();
            if (operator.equals("+")) {
                validOperator = true;
            } else if (operator.equals("-")) {
                validOperator = true;
            } else if (operator.equals("*")) {
                validOperator = true;
            } else {
                System.out.println("Bitte einen von den Operatoren eingeben.");
            }
        }


        return operator;
    }

    public static float readFloatFromConsole(String msg){
        float zahl = 0f;
        boolean validNumber = false;
        while (!validNumber){
            try {
                System.out.print(msg);
                zahl = sc.nextFloat();
                validNumber = true;
            } catch (InputMismatchException ime){
                System.out.println("ERROR: Es ist keine gültige Zahl.");
            }
            sc.nextLine();
        }
        return zahl;
    }
}
