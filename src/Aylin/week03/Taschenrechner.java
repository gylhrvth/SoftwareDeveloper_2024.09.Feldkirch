package Aylin.week03;

import java.util.Scanner;

public class Taschenrechner {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float num1 = printNumber("Gib die erste Zahl ein: ");
        String operator = getOperator();
        float num2 = printNumber("Gib die zweite Zahl ein: ");
        float result = calculate(num1, operator, num2);
        System.out.println("Dein Ergebnis ist: " + result);
    }

    public static float printNumber(String msg){
        float num = 0;
        boolean validNumber = false;

        while (!validNumber){
            try{
                System.out.print(msg);
                num = Float.parseFloat(scanner.nextLine());
                validNumber = true;
            }catch(NumberFormatException nfe) {
                System.out.print("Ungültige Zahl. Bitte versuchen Sie es erneut.");
            }
        }
        return num;
    }

    public static String getOperator(){
        String operator = "";
        boolean validOperator = false;

        while(!validOperator){
            System.out.print("Bitte geben Sie einen Operator ein: ");
            operator = scanner.nextLine();
            if((operator.equals("+")) || (operator.equals("-")) || (operator.equals("*")) || (operator.equals("/"))){
                validOperator = true;
            }
        }
        return operator;
    }

    public static float calculate(float num1, String operator, float num2) {

        if ((operator.equals("+")) || (operator.equals("-")) || (operator.equals("*")) || (operator.equals("/"))){
            return num1 + num2;
        } else {
            System.out.println("Ungültiger Operator. Bitte versuchen Sie es erneut.");
            return 0;
        }
    }
}
