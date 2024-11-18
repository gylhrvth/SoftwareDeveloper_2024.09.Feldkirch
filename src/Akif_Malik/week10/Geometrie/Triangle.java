package Akif_Malik.week10.Geometrie;

public class Triangle extends Geo {

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
