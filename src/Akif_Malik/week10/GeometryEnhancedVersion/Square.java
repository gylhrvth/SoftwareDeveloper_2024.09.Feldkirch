package Akif_Malik.week10.GeometryEnhancedVersion;

public class Square extends Geo{

    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public double getCircumference() {
        return length*4;
    }

    @Override
    public double getArea() {
        return length*length;
    }
}
