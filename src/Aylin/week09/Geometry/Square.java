package Aylin.week09.Geometry;

public class Square extends Rectangle{
    private double size;

    public Square(double size) {
        super(size, size);
    }

    @Override
    public double getCircumference() {
        return 2 * size;
    }

    @Override
    public double getArea() {
        return size * size;
    }
}
