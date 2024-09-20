package Aylin.week02;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to the ultimate guessing adventure! \nGuess the number between " + 0 + " and " + 100 + " !");

        returnGame("Enter your Number: ", 0, 100);
        System.out.println("Congratulations!!! You win!");
    }
    public static int returnGame(String userInput, int minValue, int maxValue){
        int randomNumber = new Random().nextInt(0, 101);
//        System.out.println(randomNumber);
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (!validNumber){
            try{
                System.out.print(userInput);
                String text = sc.nextLine();
                number = Integer.parseInt(text);
                if(number >= minValue && number <= maxValue && number == randomNumber ){
                    validNumber = true;
                }else if(randomNumber < number) {
                    System.out.println("Your number is to high.");
                }else if(randomNumber > number) {
                    System.out.println("Your number is to low");
                }else {
                        System.out.print("The number must be between " + minValue + " and " + maxValue + ". \n");
                }
            }catch (NumberFormatException nfe){
                System.out.print("Something went wrong. \n" + nfe + "\n");
            }
        }
        return  number;
    }
}
