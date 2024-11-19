package Akif_Malik.week10.GeometrieInterface;

public class Rectangle implements Geo {

    private int width;

    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getCircumference() {
        return 2*(width +height);
    }

    @Override
    public double getArea() {
        return height*width;
    }
}
