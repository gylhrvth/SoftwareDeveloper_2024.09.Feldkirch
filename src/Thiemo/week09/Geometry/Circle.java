package Thiemo.week09.Geometry;

public class Circle extends Geometry {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        double result = (radius * 2) * Math.PI;
        return result;
    }

    @Override
    public double getArea() {
        double result = Math.PI * radius* radius;
        return result;
    }
}
