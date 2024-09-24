package Gyula.week03;

import java.util.Scanner;

public class StringCompare {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String text = scanner.nextLine();
        if (text.equals("Birne")){
            System.out.println("Ich habe eine Birne");
        } else {
            System.out.println("Ich mag es nicht");
        }
    }
}
