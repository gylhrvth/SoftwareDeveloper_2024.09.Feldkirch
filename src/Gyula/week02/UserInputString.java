package Gyula.week02;

import java.util.Scanner;

public class UserInputString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Deine Name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name + "!");
    }
}
