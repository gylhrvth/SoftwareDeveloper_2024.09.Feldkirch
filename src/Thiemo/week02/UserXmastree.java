package Thiemo.week02;

import java.util.Scanner;

public class UserXmastree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib die Grösse an: ");
        int size = sc.nextInt();

        Thiemo.week01.christmastree.christmastree(size);
    }
}