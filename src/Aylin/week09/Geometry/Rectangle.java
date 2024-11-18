package Aylin.week09.Geometry;

public class Rectangle extends Geometry{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public double getCircumference() {
        return 2 * (height + width);
    }

    @Override
    public double getArea() {
        return height * width;
    }
}
