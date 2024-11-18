package Thiemo.week10.GeometryInterface;

public class Rectangle implements Geometry{

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getCircumference() {
        return (width*2)+(height *2) ;
    }
}
