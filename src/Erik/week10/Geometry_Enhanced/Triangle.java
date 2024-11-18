package Erik.week10.Geometry_Enhanced;

public class Triangle implements IGeometry {

    // Attribute
    private double size;


    // Konstruktor
    public Triangle(double size) {
        this.size = size;
    }


    // Methoden
    @Override
    public double getCircumference() {
        return 3 * size;
    }

    @Override
    public double getArea() {
        return (size * size) / 2;
    }
}