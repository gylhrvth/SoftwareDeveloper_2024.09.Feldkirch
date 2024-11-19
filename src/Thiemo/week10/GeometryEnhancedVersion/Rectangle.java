package Thiemo.week10.GeometryEnhancedVersion;

public class Rectangle implements Geometry{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getCircumference() {
        return height*2 + width*2;
    }

    @Override
    public double getArea() {
        return height*width;
    }
}
