package Akif_Malik.week10.GeometryEnhancedVersion;

public class HausVomNikolaus extends Geo{

    private Square square;

    private Triangle triangle;

    private int size;


    public HausVomNikolaus(int size) {
        this.square = new Square(size);
        this.triangle = new Triangle(size);
    }

    @Override
    public double getCircumference() {
        return square.getCircumference() + triangle.getCircumference() -5;
    }

    @Override
    public double getArea() {
        return square.getArea() + triangle.getArea();
    }
}
