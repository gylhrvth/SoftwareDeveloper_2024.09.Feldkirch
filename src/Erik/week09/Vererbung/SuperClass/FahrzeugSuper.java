package Erik.week09.Vererbung.SuperClass;

public class FahrzeugSuper {

    // Attribute
    private String brand;
    private String engine;
    private int wheel;


    // Konstruktor
    public FahrzeugSuper(String brand, String engine, int wheel) {
        this.brand = brand;
        this.engine = engine;
        this.wheel = wheel;
        System.out.println("Ich bin der Konstruktor von der Klasse 'FahrzeugSuper'");
    }


    // Methoden
    public void drive() {
        System.out.println("drives");
    }

    public void start() {
        System.out.println("starts");
    }
}