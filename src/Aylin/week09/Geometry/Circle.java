package Aylin.week09.Geometry;

public class Circle extends Geometry {
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
