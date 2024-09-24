package Thiemo.week03;

import java.util.Scanner;

public class Taschenrechner {


    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        float number1 = userInput("Deine erstel Zahl");
        String operator = readOperator("Operator eingeben (+,-,*,/,^)");
        float number2 = userInput("Deine zweite Zahl");
        float result = calculate(operator, number1, number2);
        System.out.println("Ergebnis: " + result);

    }


    public static float userInput(String userinfo) {
        float number = 0f;
        boolean richtigeEingabe = false;

        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                number = Float.parseFloat(sc.nextLine());
                richtigeEingabe = true;

            } catch (NumberFormatException nfe) {
                System.out.println("Error! Please try a valid number.\n");
            }

        }
        return number;
    }

    public static String readOperator(String userinfo) {

        String operator = "";
        boolean richtigeEingabe = false;

        while (!richtigeEingabe) {
            System.out.println(userinfo);
            operator = sc.nextLine();
            if (operator.equals("+")) {
                richtigeEingabe = true;

            } else if (operator.equals("-")) {
                richtigeEingabe = true;

            } else if (operator.equals("/")) {
                richtigeEingabe = true;
                ;
            } else if (operator.equals("*")) {
                richtigeEingabe = true;

            } else if (operator.equals("^")) {
                richtigeEingabe = true;


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
            result = (float)Math.pow(num1,num2);
        }


        return result;
    }

}



