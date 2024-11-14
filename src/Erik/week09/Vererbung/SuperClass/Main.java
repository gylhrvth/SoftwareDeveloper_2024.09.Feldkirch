package Erik.week09.Vererbung.SuperClass;

import Sandro.Colors;

public class Main {
    public static void main(String[] args) {

        System.out.println("─".repeat(80));
        System.out.println(Colors.COLORS[1] + ">> Verknüpfungs Hierarchie << " + Colors.RESET);
        System.out.println("─".repeat(80));


        System.out.println(Colors.COLORS[1] + ">> Erstellung von Objekt FahrzeugSuper <<" + Colors.RESET);
        FahrzeugSuper vehicle = new FahrzeugSuper("unknown", "unknown", 4);


        System.out.println("─".repeat(80));


        System.out.println(Colors.COLORS[1] + ">> Erstellung von Objekt Auto <<" + Colors.RESET);
        Auto carFord = new Auto("Ford", "Unknown", 4, 4);


        System.out.println("─".repeat(80));


        System.out.println(Colors.COLORS[1] + ">> Erstellung von Objekt Motorrad <<" + Colors.RESET);
        Motorrad bike = new Motorrad("BMW", "Unknown", 2, 2);


        System.out.println("─".repeat(80));


        System.out.println(Colors.COLORS[1] + ">> Erstellung von Objekt Moped <<" + Colors.RESET);
        Moped smallBike = new Moped("Gilera", "Unknown", 2, 1, 48, "50ccm");


        System.out.println("─".repeat(80));
    }
}