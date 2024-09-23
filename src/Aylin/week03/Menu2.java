package Aylin.week03;

import java.util.Scanner;

public class Menu2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to my Assingments. \nWhat would you like to print?\n" +
                        "1) XmasTree \n" +
                "2) Square \n" +
                "3) Rhombus ");

        int selectSymbol = number ("Please choose now: ", 1, 3);
        System.out.print("Your choice: " + selectSymbol);
        if(selectSymbol == 1){
            System.out.println();
        }else if(selectSymbol == 2){
            menuSquare();
        }else if (selectSymbol == 3){
            menuRhombus();
        }
    }

    public static void menuXmasTree (){
        int size = number("Wie Groß soll das XmasTree sein? ", 1 , 50);
        Aylin.week01.PrintChristmastree.printChristmastree(size);
    }

    public static void menuSquare(){
        int size = number("Wie Groß soll der Square sein? ", 2, 50);
        String character = readText("Which Symbol should be used? ");
        Aylin.week01.Square.printEmptySquare(character, size);
    }

    public static void menuRhombus(){
        int size = number("Wie Groß soll der Rhombus sein? ", 3, 50);
        String character = readText("Which Symbol should be used? ");
        Aylin.week01.Rhombus.printRhombus(character, size);
    }

    public static int number (String userInput, int firstNumber, int lastNumber){
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (!validNumber){
            try{
                System.out.println(userInput);
                String tempText = sc.nextLine();
                number = Integer.parseInt(tempText);
                if(number >= firstNumber && number <= lastNumber ){
                    validNumber = true;
                }else{
                    System.out.println("Input Number must be between " + firstNumber + "and " + lastNumber);
                }
            }catch(NumberFormatException nfe) {
                System.out.print("Something went wrong. " + nfe + "\n" + userInput);
            }
        }
        return number;
    }

    public static String readText (String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
