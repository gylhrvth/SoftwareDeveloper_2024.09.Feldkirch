package Aylin.week10.GeometryInterface;

public class Rectangle implements IGeometry {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if(width < 0 || height < 0){
            width = 0;
            height = 0;
        }
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