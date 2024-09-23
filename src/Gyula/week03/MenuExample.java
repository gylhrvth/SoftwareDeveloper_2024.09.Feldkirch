package Gyula.week03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuExample {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Willkommen bei meinen Aufgaben!\n" +
                "Was möchten Sie zeichnen?\n" +
                "1) Christbaum\n" +
                "2) Quader\n" +
                "3) Rhombus");
        int choise = readNumber("Bitte wählen Sie nun?", 1, 3);

        if (choise == 1){
            int size = readNumber("Bitte die Größe des Baums auswählen!", 3, 50);
            String symbol = readSymbol("Bitte geben Sie das Symbol des Baums!");
            Erik.week01.PrintChristmastreeV1.printWholeTree(symbol, size);
        } else if (choise == 2) {
            System.out.println("Quader");
        } else {
            System.out.println("Rhombus");
        }
    }

    public static String readSymbol(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int readNumber(String message, int minValid, int maxValid){
        System.out.println(message);
        int result = 1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(">>> ");
                result = scanner.nextInt();
                scanner.nextLine();
                if (result >= minValid && result <= maxValid) {
                    valid = true;
                } else {
                    System.out.println("Du musst eine Zahl zwischen " + minValid + " und " + maxValid + " eingeben.");
                }
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Du musst eine Zahl eingeben.");
            }
        }
        return result;
    }
}
