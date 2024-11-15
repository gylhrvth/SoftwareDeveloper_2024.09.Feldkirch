package Sandro.Week9.Vererbung.Geometrie;

public class Rectangle extends Geo{
    private double width;
    private double height;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //2 mal (länge + breite) /
    @Override
    public double getCircumference() {
        return 2*(width +height);
    }
    //Länge mal Breite
    @Override
    public double getArea() {
        return height*width;
    }
}
