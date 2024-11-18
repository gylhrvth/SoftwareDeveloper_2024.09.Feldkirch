package Aylin.week09.Geometry;

import java.util.List;
import java.util.Vector;

public class main {
    public static void main(String[] args) {

        List<Geometry> geometries = new Vector<>();
        geometries.add(new Triangle(30));
        geometries.add(new Rectangle(24, 36));
        geometries.add(new Circle(40));
        geometries.add(new Square(50));

        int sumOfAllAreas = 0;
        int sumOfAllCircumferences = 0;

        for (Geometry g : geometries){
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
