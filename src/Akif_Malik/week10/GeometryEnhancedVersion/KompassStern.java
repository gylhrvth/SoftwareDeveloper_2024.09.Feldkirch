package Akif_Malik.week10.GeometryEnhancedVersion;

public class KompassStern extends Geo{

    private Square square;

    private Triangle triangle;

    public KompassStern(int size) {
        this.square = new Square(size);
        this.triangle = new Triangle(size);
    }

    @Override
    public double getCircumference() {
        return triangle.getCircumference()* 4 - square.getCircumference();
    }

    @Override
    public double getArea() {
        return triangle.getArea() * 4 + square.getArea();
    }
}
