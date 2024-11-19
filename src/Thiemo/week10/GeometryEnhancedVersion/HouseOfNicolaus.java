package Thiemo.week10.GeometryEnhancedVersion;

public class HouseOfNicolaus implements Geometry {

private Triangle triangle;
private Rectangle rectangle;

    public HouseOfNicolaus(int size) {
        this.triangle =  new Triangle (size);
        this.rectangle = new Rectangle(size,size);
    }


    @Override
    public double getCircumference() {
        return (triangle.getCircumference()-(triangle.getCircumference()/3)+(rectangle.getCircumference()-(rectangle.getCircumference()/4)));
    }

    @Override
    public double getArea() {
        return triangle.getArea()+rectangle.getArea();
    }
}
