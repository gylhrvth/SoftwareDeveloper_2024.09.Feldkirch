package Thiemo.week10.GeometryInterface;

public class Circle implements Geometry {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {

        return radius * radius * Math.PI;
    }

    @Override
    public double getCircumference() {

        return 2 * radius * Math.PI;
    }
}

