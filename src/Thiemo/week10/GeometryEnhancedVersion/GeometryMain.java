package Thiemo.week10.GeometryEnhancedVersion;

import java.util.Vector;

public class GeometryMain {
    public static void main(String[] args) {

        Vector<Geometry> geoList = new Vector<>();

        geoList.add(new Triangle(7));
        geoList.add(new Rectangle(7, 7));
        geoList.add(new Circle(5));
        geoList.add(new Square(7));
        geoList.add(new HouseOfNicolaus(7));
        geoList.add(new Star(10));



        double sumOfAllCircumfences = 0;
        double sumOfAllAreas = 0;

        for (Geometry geolist : geoList) {

            System.out.printf("Area of " + geolist.getClass().getSimpleName() + " == %.2f ", geolist.getArea());
            System.out.printf("Circumfence of " + geolist.getClass().getSimpleName() + " == %.2f ", geolist.getCircumference());
            System.out.println("\n");

            sumOfAllAreas += geolist.getArea();
            sumOfAllCircumfences += geolist.getCircumference();


        }
        System.out.printf("Sum of all Areas == %.4f", sumOfAllAreas);
        System.out.printf(" Sum of all Circumfences == %.4f", sumOfAllCircumfences);
    }
}

