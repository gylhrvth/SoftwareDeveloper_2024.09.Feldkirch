package Aylin.week02;

import java.util.Scanner;

public class UserInputXmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib die Grösse an: ");
        int size = sc.nextInt();

        Aylin.week01.PrintChristmastree.printChristmastree(size);
    }
}
