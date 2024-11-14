package Erik.week09.Vererbung.SuperClass;

public class Motorrad extends FahrzeugSuper {


    // Attribute
    private int suitCaseHolder;


    // Konstruktor
    public Motorrad(String brand, String engine, int wheel, int suitCaseHolder) {
        super(brand, engine, wheel);            // Holt, dass Zeug aus der Klasse "FahrzeugSuper"
        this.suitCaseHolder = suitCaseHolder;   // Attribute von dieser Klasse
    }


    // Methoden
    public void wheelie() {
        System.out.println("wheelie");
    }

}