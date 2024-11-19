package Erik.week10.Geometry_Enhanced;

public class KompassStar implements IGeometry {

    // Attribute
    private Square square;
    private Triangle triangle;


    // Konstruktor
    public KompassStar(double size) {
        this.square = new Square(size);
        this.triangle = new Triangle(size);
    }

    // Methoden
    @Override
    public double getCircumference() {
        return (triangle.getCircumference() / 3) * 8; // 26,67
    }

    @Override
    public double getArea() {
        return square.getArea() + (triangle.getArea() * 4);
    }
}