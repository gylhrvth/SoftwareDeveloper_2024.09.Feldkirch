package Erik.week03;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Todo:   1. Einleitung mit auswahlmöglichkeiten ♥
        2. Variable int Choice | If else zum auswählen 1,2,3 ♥
        3. Scanner erstellen ♥
        4. Int/String Funktion für User eingabe mit min und max Value
        5. Try und Catch
        6. Größen einstellung
        7. Zeichen Einstellung
        8. Funktion aufruf für Symbole/Auswahl
        Bonus 9. Wiederholung ja/nein
*/
public class Menu2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int minValue = 1;
        int maxValue = 3;

        System.out.println("Willkommen bei meinen Aufgaben!\n" +
                "Was möchten Sie zeichnen?\n" +
                "1) Christbaum\n" +
                "2) Quader\n" +
                "3) Rhombus\n" +
                "Bitte wählen Sie nun?");


        int choice = Usereingabe("Wähle zwischen 1-3", 1,3);

        if (choice == 1) {
            System.out.println(1);
        } else if (choice == 2) {
            System.out.println(2);
        } else if (choice == 3){
            System.out.println(3);
        }
    }
    public static int Usereingabe (String msg, int minValue, int maxValue){
        int UserInput = 0;
        boolean validNumber = true;

        while (validNumber) {
            try {
                UserInput = sc.nextInt();

                if (UserInput >= minValue && UserInput <= maxValue) {
                    System.out.println("♥");
                } else {
                    System.out.println("-.-");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error Give Number between " + minValue + " und " + maxValue);
            }
        }


        return UserInput;
    }
}
