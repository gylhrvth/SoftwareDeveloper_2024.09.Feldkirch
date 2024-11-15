package Thiemo.week09.Geometry;

public class Rectangle extends Geometry {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getCircumference() {
        double result = (width*2) + (height*2);
        return result;
    }

    @Override
    public double getArea() {
        double result = width+height;
        return result;
    }
}
