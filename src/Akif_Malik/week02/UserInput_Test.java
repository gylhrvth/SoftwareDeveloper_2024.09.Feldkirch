package Akif_Malik.week02;

import java.util.Scanner;

public class UserInput_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib einen symbol und die Größe ein: ");
        String text = sc.next();
        int count = sc.nextInt();

        Akif_Malik.week01.PrintRhombus.printRhombus(text, count);

    }
}
