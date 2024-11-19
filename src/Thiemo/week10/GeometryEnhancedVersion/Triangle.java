package Thiemo.week10.GeometryEnhancedVersion;

public class Triangle implements Geometry {

    private double length;

    public Triangle(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return (length*length) +0.5;
    }

    @Override
    public double getCircumference() {
        return length*3;
    }
}
