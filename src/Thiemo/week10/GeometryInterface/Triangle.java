package Thiemo.week10.GeometryInterface;

public class Triangle implements Geometry{

    private double length;

    public Triangle(double length) {
        this.length = length;
    }

    @Override
    public double getCircumference() {
        return length*3;
    }

    @Override
    public double getArea() {
        return (length*length) /2;
    }
}
