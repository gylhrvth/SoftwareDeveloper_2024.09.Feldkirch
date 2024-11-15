package Furkan.week10.Geometry;

public class Triangle extends Geometry {
    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getCircumference() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
