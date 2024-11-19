package Erik.week09.Geometry;

public class Triangle extends Geometry {

    // Attribute
    private double a;
    private double b;
    private double c;
    private double height;

    // Konstruktor
    public Triangle(double a, double b, double c, double height) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
    }


    // Methoden
    @Override
    public double getCircumference() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        return (a * height) / 2;
    }
}