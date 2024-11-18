package Erik.week10.Geometry_Interface;

public class Circle implements Geometry {

    // Attribute
    private double radius;


    // Konstruktor
    public Circle(double radius) {
        this.radius = radius;
    }


    // Methoden
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}