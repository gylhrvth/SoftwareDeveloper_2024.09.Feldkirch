package Akif_Malik.week10.GeometryEnhancedVersion;

public class Triangle extends Geo {
    private double length;
    private double base;

    public Triangle(double length) {
        this.length = length;
    }

    @Override
    public double getCircumference() {
        return length*3;
    }

    @Override
    public double getArea() {
        return length * length * Math.sqrt(3) / 4;
    }
}
