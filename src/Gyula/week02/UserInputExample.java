package Gyula.week02;

import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib bitte einen Symbol und die Größe ein: ");
        String text = sc.next();
        int size = sc.nextInt();

        Gyula.week01.TriangleExample.printTriangle(text, size);
    }
}
