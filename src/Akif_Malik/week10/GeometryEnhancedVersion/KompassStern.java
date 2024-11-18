package Akif_Malik.week10.GeometryEnhancedVersion;

public class KompassStern extends Geo{

    private Square square;

    private Triangle triangle;

    public KompassStern() {
        this.square = new Square(5);
        this.triangle = new Triangle(5);
    }

    @Override
    public double getCircumference() {
        return 1;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
