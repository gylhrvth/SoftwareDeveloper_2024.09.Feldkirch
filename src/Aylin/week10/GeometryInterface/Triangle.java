package Aylin.week10.GeometryInterface;

public class Triangle implements IGeometry {
    private double length;

    public Triangle(double length) {
        if(length < 0){
            length = 0;
        }
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
