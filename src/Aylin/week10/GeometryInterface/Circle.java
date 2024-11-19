package Aylin.week10.GeometryInterface;

public class Circle implements IGeometry {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius ;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}