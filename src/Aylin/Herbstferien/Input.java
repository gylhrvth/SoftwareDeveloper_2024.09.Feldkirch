package Aylin.Herbstferien;

import java.util.Scanner;

public class Input {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        printUserInput();
    }

    public static void printUserInput(){
        System.out.println("Please enter a text: ");
        String userInput = sc.nextLine();
        System.out.println("How many times should the text be repeated? ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println(userInput);
        }
    }
}
