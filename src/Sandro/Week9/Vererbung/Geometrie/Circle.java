package Sandro.Week9.Vererbung.Geometrie;

public class Circle extends Geo{
    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    //2 mal Radius mal Pi
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }
    // (radius mal radius ) mal PI
    @Override
    public double getArea() {
        return (radius * radius) * Math.PI;
    }

}
