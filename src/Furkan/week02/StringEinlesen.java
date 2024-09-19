package Furkan.week02;


import java.util.Scanner;

public class StringEinlesen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib bitte einen Symbol und die Größe ein: ");
        String text = sc.next();
        int size = sc.nextInt();

        Furkan.week01.PrintRhombus.printRhombus(text,size);

    }
}
