package Furkan.week10.Geometry;

public class Square extends Geometry{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getCircumference() {
        return 4* side;
    }

    @Override
    public double getArea() {
        return side * side;
    }





}
