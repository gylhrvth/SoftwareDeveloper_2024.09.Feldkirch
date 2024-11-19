package Akif_Malik.week10.GeometrieInterface;

public class Triangle implements Geo {
    private int length;

    public Triangle(int length) {
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
