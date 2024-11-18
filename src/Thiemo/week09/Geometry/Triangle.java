package Thiemo.week09.Geometry;

public class Triangle extends Geometry {
    private double length;

    public Triangle(double length) {
        this.length = length;
    }


    @Override
    public double getCircumference() {
        double result = length * 3;
        return result;
    }

    @Override
    public double getArea() {
        double result = (length + length) / 2;
        return result;
    }
}
