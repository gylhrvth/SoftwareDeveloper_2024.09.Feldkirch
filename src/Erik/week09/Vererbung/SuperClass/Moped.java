package Erik.week09.Vererbung.SuperClass;

public class Moped extends Motorrad {


    // Attribute
    private int maxSpeed;
    private String size;


    // Konstruktor
    public Moped(String brand, String engine, int wheel, int suitCaseHolder , int maxSpeed, String size) {
        super(brand, engine, wheel, suitCaseHolder);        // Holt, dass Zeug aus der Klasse "Motorrad"
        this.maxSpeed = maxSpeed;                           // Attribute von dieser Klasse
        this.size = size;
    }


    // Methoden
    public void mopedThings() {
        System.out.println("Moped Things....");
    }

}