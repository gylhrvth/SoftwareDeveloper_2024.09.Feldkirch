package Sandro.Week9.Vererbung.Geometrie;

public class Triagle extends Geo {
    private double length;


    public Triagle(double length) {
        this.length = length;
    }

    @Override
    public double getCircumference() {
        return 3 * length;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * length * length / 4.0;
    }


}
