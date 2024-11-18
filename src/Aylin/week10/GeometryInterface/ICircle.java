package Aylin.week10.GeometryInterface;

public class ICircle implements IGeometry {
    private double radius;

    public ICircle(double radius) {
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