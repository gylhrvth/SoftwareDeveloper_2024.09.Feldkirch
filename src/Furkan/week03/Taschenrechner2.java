package Furkan.week03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Taschenrechner2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float num1 = readNumber("Gib deine erste Zahl ein.");
        String operator = readOperator("Wähle deinen Operator");
        float num2 = readNumber("Gib deine zweite Zahl ein.");
        float result = calculate(operator, num1, num2);
        System.out.println("Ergebnis" + result);

    }

    public static float readNumber(String msg) {
        float number = 0f;
        boolean NumberIsValid = false;

        while (!NumberIsValid) {
            try {
                System.out.println(msg);
                number = Float.parseFloat(scanner.nextLine());
                NumberIsValid = true;


            } catch (InputMismatchException ime) {
                System.out.println("Sorry,that was not a Valid number");
            }

        }
        return number;
    }

    public static String readOperator(String msg) {
        String operator = "";
        boolean validOperator = false;

        while (!validOperator) {
            System.out.println(msg);
            operator = scanner.nextLine();
            if (operator.equals("+")) {
                validOperator = true;

            } else if (operator.equals("-")) {
                validOperator = true;

            } else if (operator.equals("*")) {
                validOperator = true;

            } else if (operator.equals("/")) {
                validOperator = true;

            } else if (operator.equals("^")) {
                validOperator = true;


            }

        }
        return operator;

    }

    public static float calculate(String operator, float num1, float num2) {


        float result = 0f;

        if (operator.equals("+")) {
            result = num1 + num2;

        } else if (operator.equals("-")) {
            result = num1 - num2;

        } else if (operator.equals("*")) {
            result = num1 * num2;

        } else if (operator.equals("/")) {
            result = num1 / num2;

        } else if (operator.equals("^")) {
            result = (float) Math.pow(num1, num2);


        }
        return result;


    }
}






