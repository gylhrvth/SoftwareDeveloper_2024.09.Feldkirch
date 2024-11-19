package Akif_Malik.week10.GeometrieInterface;

public class Circle implements Geo {

    private int radius;

    public Circle(int radius) {
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
