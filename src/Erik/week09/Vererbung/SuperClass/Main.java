package Erik.week09.Vererbung.SuperClass;

public class Main {
    public static void main(String[] args) {

        FahrzeugSuper vehicle = new FahrzeugSuper("unknown", "unknown",4);
        Auto carFord = new Auto("Ford", "Unknown", 4, 4);
        Motorrad bike = new Motorrad("BMW", "Unknown", 2, 2);
        Moped smallBike = new Moped("Gilera", "Unknown", 2, 1,48, "50ccm");
    }

}