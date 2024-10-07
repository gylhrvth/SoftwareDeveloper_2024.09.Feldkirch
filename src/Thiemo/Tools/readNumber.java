package Thiemo.Tools;

import java.util.Scanner;

public class readNumber {
    public static int readNumber(String userInput, int minValue, int maxValue){
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
                    System.out.println("Input Number must be between " + minValue + " and " + maxValue);
                }
            }catch(NumberFormatException nfe) {
                System.out.print("Something went wrong. " + nfe.getMessage() + "\n" + userInput);
            }
        }
        return number;
    }

}

