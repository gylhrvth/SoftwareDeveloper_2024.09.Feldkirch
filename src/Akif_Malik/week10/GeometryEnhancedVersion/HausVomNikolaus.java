package Akif_Malik.week10.GeometryEnhancedVersion;

public class HausVomNikolaus extends Geo{

    private Square square;

    private Triangle triangle;


    public HausVomNikolaus() {
        this.square = new Square(5);
        this.triangle = new Triangle(5);
    }

    @Override
    public double getCircumference() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
