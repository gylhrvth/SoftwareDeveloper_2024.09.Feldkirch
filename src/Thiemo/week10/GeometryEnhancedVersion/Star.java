package Thiemo.week10.GeometryEnhancedVersion;

public class Star implements Geometry {

    private Rectangle rectangle;
    private Triangle triangle;


    public Star(int size) {
        this.rectangle = new Rectangle(size,size);
        this.triangle = new Triangle(size);
    }

    @Override
    public double getCircumference() {
        return ((triangle.getCircumference()/3) * 8);
    }

    @Override
    public double getArea() {
        return ((triangle.getArea()*4)+rectangle.getArea());
    }
}
