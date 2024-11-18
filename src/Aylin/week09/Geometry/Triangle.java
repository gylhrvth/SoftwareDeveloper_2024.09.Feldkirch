package Aylin.week09.Geometry;

public class Triangle extends Geometry{
    private double length;

    public Triangle(double length) {
        this.length = length;
    }

    @Override
    public double getCircumference() {
        return 3 * length;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * length * length / 4.0;
    }
}
