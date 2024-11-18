package Aylin.week10.GeometryInterface;

public class IRectangle implements IGeometry {
    private double width;
    private double height;

    public IRectangle(double width, double height) {
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