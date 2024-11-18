package Aylin.week10.GeometryInterface;

import java.util.List;
import java.util.Vector;

public class IMain {
    public static void main(String[] args) {

        List<IGeometry> geometries = new Vector<>();
        geometries.add(new ITriangle(30));
        geometries.add(new IRectangle(24, 36));
        geometries.add(new ICircle(5));
        geometries.add(new ISquare(50));

        int sumOfAllAreas = 0;
        int sumOfAllCircumferences = 0;

        for (IGeometry g : geometries){
            System.out.println("Area of " + g.getClass().getSimpleName() + ": " + g.getArea());
            System.out.println("Circumference of " + g.getClass().getSimpleName() + ": " + g.getCircumference());
            System.out.println();
            sumOfAllAreas += g.getArea();
            sumOfAllCircumferences += g.getCircumference();
        }

        System.out.println("Sum of all Areas: " + sumOfAllAreas);
        System.out.println("Sum of all Circumferences: " + sumOfAllCircumferences);
    }
}
