package Erik.week10.Geometry_Enhanced;

public class HouseFromNikolaus implements IGeometry {

    // Attribute
    private Triangle triangle;
    private Square square;


    // Konstruktor
    public HouseFromNikolaus(double size) {
        this.triangle = new Triangle(size);
        this.square = new Square(size);
    }


    // Methoden
    @Override
    public double getCircumference() {
        return (triangle.getCircumference() - (triangle.getCircumference() / 3)) + (square.getCircumference() - (square.getCircumference() / 4));
    }

    @Override
    public double getArea() {
        return triangle.getArea() + square.getArea();
    }
}