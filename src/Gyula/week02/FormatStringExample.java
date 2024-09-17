package Gyula.week02;

public class FormatStringExample {
    public static void main(String[] args) {
        System.out.println(5);
        System.out.println(55);
        System.out.println(555);
        System.out.println(5656);
        System.out.println(56644);
        System.out.println("Heute ist " + 5 + " Grad Celsius.");
        System.out.println("Heute ist " + 53 + " Grad Celsius.");
        System.out.println("Heute ist " + 545 + " Grad Celsius.");
        System.out.println("Heute ist " + 5454 + " Grad Celsius.");

        System.out.printf("Heute ist %d Grad Celsius.\n", 2);
        System.out.printf("Heute ist %d Grad Celsius.\n", 22);
        System.out.printf("Heute ist %d Grad Celsius.\n", 222);
        System.out.printf("Heute ist %d Grad Celsius.\n", 2222);

        System.out.printf("Heute ist %4d Grad Celsius.\n", 3);
        System.out.printf("Heute ist %4d Grad Celsius.\n", 33);
        System.out.printf("Heute ist %4d Grad Celsius.\n", 333);
        System.out.printf("Heute ist %4d Grad Celsius.\n", 3333);

        System.out.printf("Heute ist %-4d Grad Celsius.\n", 4);
        System.out.printf("Heute ist %-4d Grad Celsius.\n", 44);
        System.out.printf("Heute ist %-4d Grad Celsius.\n", 444);
        System.out.printf("Heute ist %-4d Grad Celsius.\n", 4444);

        System.out.printf("Say hello to %s.\n", "Sandro");
        System.out.printf("Say hello to %s.\n", "Akif");

        System.out.printf("Say by to %-6s.\n", "Sandro");
        System.out.printf("Say by to %-6s.\n", "Akif");

        System.out.printf("Hello %d und %d. Willkommen in %s!\n", 3, 5, "Feldkirch");
        // System.out.printf("Hello %d und %d. Willkommen in %s! %d\n", 3, 5, "Feldkirch"); // Anzahl Parameter muss die % Angaben entsprechen...

    }
}
