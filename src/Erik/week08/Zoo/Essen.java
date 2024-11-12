package Erik.week08.Zoo;

public class Essen {

    // Attribute
    private String name;
    private int einheit;
    private int einheitsPreis;


    // Konstruktor
    public Essen(String name, int einheit, int einheitsPreis) {
        this.name = name;
        this.einheit = einheit;
        this.einheitsPreis = einheitsPreis;
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public int getEinheit() {
        return einheit;
    }

    public int getEinheitsPreis() {
        return einheitsPreis;
    }


    // Methoden
}