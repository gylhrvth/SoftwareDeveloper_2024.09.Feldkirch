package Erik.week09.Geometry;

public class Square extends Rectangle {

    // Attribute
    private double length;


    // Konstruktor
    public Square(double length) {
        super(length, length);
    }


    // Methoden
    public double getCircumference() {
     return 4 * length;
    }

    public double getArea() {
        return length * length;
    }
}