package Aylin.week02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) {
        String name= "";
        String ort = "";
        int age = 0;

//        System.out.print("Welcome, please enter your Name: ");
        name = returnString("Welcome, please enter your Name: ");
        System.out.println("Good morning " + name + "!");

//        System.out.print("Where do you live? ");
        ort = returnString("Where do you live? ");
        System.out.println("Wow, so you are from " + ort + ".");

//        System.out.print("Enter your age: ");
        age = printNumber("Enter your age: ", 0, 100);
        if(age==1){
            System.out.println("aah, you are " + age + " year old!");
        }else{
            System.out.println("aah, you are " + age + " years old!");
        }
//        System.out.println("You are " + age + " years old!");

    }

    public static String returnString(String userInfo){
        System.out.print(userInfo);
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);
        scannerInput = sc.nextLine();
        return scannerInput;
    }

    public static int printNumber(String userInput, int minValue, int maxValue){
        System.out.print(userInput);
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (!validNumber){
            try{
                System.out.println(userInput);
                String tempText = sc.nextLine();
                number = Integer.parseInt(tempText);
                if(number >= minValue && number <= maxValue ){
                    validNumber = true;
                }else{
                    System.out.println("Input Number must be between " + minValue + "and " + maxValue);
                }
            }catch(NumberFormatException nfe) {
                System.out.print("Something went wrong. " + nfe + "\n" + userInput);
            }
        }
        return number;
    }
}
