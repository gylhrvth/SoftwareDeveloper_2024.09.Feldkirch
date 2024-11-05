package Aylin.Herbstferien.OOP.Car;

public class Car {
    public String marke;
    public String typ;
    public String farbe;
    public String ps;
    public String baujahr;

    public Car(String marke, String typ, String farbe, String ps, String baujahr){
        this.marke = marke;
        this.typ = typ;
        this.farbe = farbe;
        this.ps = ps;
        this.baujahr = baujahr;
    }

    public void printCars(Car car){
        System.out.println("*********************************");
        System.out.printf("*    %-10s %-15s * \n", "Marke:", marke);
        System.out.printf("*    %-10s %-15s * \n", "Type:", typ);
        System.out.printf("*    %-10s %-15s * \n", "Color:", farbe);
        System.out.printf("*    %-10s %-15s * \n", "PS:", ps);
        System.out.printf("*    %-10s %-15s * \n", "Baujahr:", baujahr);
        System.out.println("*********************************");
    }
}
