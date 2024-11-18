package Akif_Malik.week10.Geometrie;

public class Circle extends Geo {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double getArea() {
        return (radius * radius) * Math.PI;
    }
}
