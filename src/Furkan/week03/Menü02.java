package Furkan.week03;

import java.util.Scanner;

public class Menü02 {
    public static void main(String[] args) {
        System.out.println("Herlich Willkommen bei meinen Aufgaben!");
        selectMenu("X", 46);

    }


    public static int selectMenu(String text, int size) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Was möchten Sie zeichnen?");
            System.out.println("1) Quader ");
            System.out.println("2) Triangle ");
            System.out.println("3) Rhombus ");
            System.out.println("Bitte wählen sie nun?");
            int choice = sc.nextInt();
            int selectMenu = sc.nextInt();
            //int
            switch (choice) {
                case 1:
                    Furkan.week01.EmptySquare.printEmptySquare(text, size);
                    break;
                case 2:
                    Furkan.week01.PrintTriangle.printTriangle(text, size);
                    break;
                case 3:
                    Furkan.week01.PrintRhombus.printRhombus(text, size);
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte veruchen sie es erneut.");
                    sc.nextLine();
                    System.out.println();
                    continue;
            }
            System.out.println("Möchten sie noch etwas zeichnen? (j/n)>>>");
            String again = sc.next();
            if (!again.equalsIgnoreCase("j")) {
                System.out.println("Auf wiedersehen!");
                break;
            }
            return selectMenu;

        }
        return size;
    }


    public static String readString() {
        String scannerInput = "";
        Scanner sc = new Scanner(System.in);

        scannerInput = sc.nextLine();
        return scannerInput;
    }
}
