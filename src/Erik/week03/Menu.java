package Erik.week03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int minSize = 1;
        int maxSize = 3;

        System.out.println("Willkommen bei meinen Aufgaben!\n" +
                "Was möchten Sie zeichnen?\n" +
                "1) Christbaum\n" +
                "2) Empty Square\n" +
                "3) Rhombus");
        System.out.println("Bitte wählen sie nun?");
        int menuChoice = tryCatch(minSize, maxSize);
        if (menuChoice == 1) {
            int size = sc.nextInt();
            Erik.week01.PrintChristmastree.printWholeTree(size);
        } else if (menuChoice == 2) {
           // Erik.week01.PrintCharacters.printEmptySquare();
        } else {

        }


    }

    public static void xMasTree() {

    }

    public static void Quader() {


    }

    public static void Rhombus() {


    }

    public static int tryCatch(int minSize, int maxSize) {

        int number = 0;
        boolean validNumber = false;

        while (!validNumber)
            try {
                System.out.println("Wählen sie zwischen " + minSize + " - " + maxSize);
                number = sc.nextInt();
                sc.nextLine();

                if (number >= minSize && number <= maxSize) {
                    validNumber = true;
                } else {
                    System.out.println("Out of range");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error! Initiating Brain.Exe");
                sc.nextLine();
            }

        return number;
    }

}
