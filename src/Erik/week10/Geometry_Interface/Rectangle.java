package Erik.week10.Geometry_Interface;

public class Rectangle implements Geometry {

    // Attribute
    private double width;
    private double height;


    // Konstruktor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Methoden
    public double getCircumference() {        // 2*height + 2*width
        return 2 * height + 2 * width;
    }

    public double getArea() {     // height * width
        return height * width;
    }
}