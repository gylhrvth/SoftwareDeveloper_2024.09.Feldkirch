package Erik.week09.Geometry;

public class Circle extends Geometry {

    // Attribute
    private double radius;


    // Konstruktor
    public Circle(double radius) {
        this.radius = radius;
    }


    // Methode
    @Override
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double getArea() {
       return radius * radius * Math.PI;
    }
}