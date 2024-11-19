package Aylin.week10.GeometryInterface;

public class HouseOfNikolaus implements IGeometry{
    private Triangle triangle;
    private Square square;
    private double size;

    public HouseOfNikolaus(double size){
        if(size < 0){
            throw new RuntimeException("Size can't be a negative number");
        }
        this.size = size;
        this.triangle = new Triangle(size);
        this.square = new Square(size);
    }

    public double getArea() {
        return triangle.getArea() + square.getArea();
    }

    @Override
    public double getCircumference() {
        return triangle.getCircumference() + square.getCircumference() - (2 * size);
    }
}
