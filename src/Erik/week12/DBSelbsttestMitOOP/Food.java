package Erik.week12.DBSelbsttestMitOOP;

public class Food {

    // Attribute
    private String name;
    private int unit;
    private int unitPrice;


    // Konstruktor
    public Food(String name, int einheit, int einheitsPreis) {
        this.name = name;
        this.unit = einheit;
        this.unitPrice = einheitsPreis;
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public int getUnit() {
        return unit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    // Methode

}