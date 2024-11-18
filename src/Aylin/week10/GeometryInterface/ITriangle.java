package Aylin.week10.GeometryInterface;

public class ITriangle implements IGeometry {
    private double length;

    public ITriangle(double length) {
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
