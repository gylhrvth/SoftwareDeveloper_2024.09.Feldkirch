package Erik.week09.Geometry;

public class Rectangle extends Geometry {

    // Attribute
    private double width;
    private double height;


    // Konstruktor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    // Methoden
    @Override
    public double getCircumference() {        // 2*height + 2*width
       return 2 * height + 2 * width;
    }

    @Override
    public double getArea() {     // height * width
       return height * width;
    }
}