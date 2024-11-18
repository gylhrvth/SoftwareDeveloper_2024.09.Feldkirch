package Erik.week10.Geometry_Enhanced;

public class Square implements IGeometry {

    // Attribute
    private double size;


    // Konstruktor
    public Square(double size) {
        this.size = size;
    }


    // Methoden
    @Override
    public double getCircumference() {
        return 4 * size;
    }

    @Override
    public double getArea() {
        return size * size;
    }
}