package Aylin.week10.GeometryInterface;

public class CompassStar implements IGeometry{
    private HouseOfNikolaus houseOfNikolaus;
    private Triangle triangle;
    private double size;

    public CompassStar(double size){
        if(size < 0){
            size = 0;
        }
        this.size = size;
        this.houseOfNikolaus = new HouseOfNikolaus(size);
        this.triangle = new Triangle(size);
    }

    public double getArea() {
        return (triangle.getArea() * 3) + houseOfNikolaus.getArea() - (4 * size);
    }

    @Override
    public double getCircumference() {
        return (triangle.getCircumference() * 3) + houseOfNikolaus.getCircumference() - (4 * size);
    }
}
