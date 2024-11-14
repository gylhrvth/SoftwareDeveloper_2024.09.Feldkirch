package Erik.week09.Vererbung.SuperClass;

public class Auto extends FahrzeugSuper {

    // Attribute
    private int doors;


    // Konstruktor
    public Auto(String brand, String engine, int wheel, int doors) {
        super(brand, engine, wheel);    // Holt, dass Zeug aus der Klasse "FahrzeugSuper"
        this.doors = doors;             // Attribute von dieser Klasse
        System.out.println("Ich bin der Konstruktor von der Klasse 'Auto'");
    }


    // Methoden
    public void openDoor() {
        System.out.println("open the door from car");
    }

}