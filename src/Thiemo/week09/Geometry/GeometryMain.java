package Thiemo.week09.Geometry;

import java.util.Vector;

public class GeometryMain {
    public static void main(String[] args) {

        Vector<Geometry> geometrylist = new Vector<>();

        geometrylist.add(new Circle(5));
        geometrylist.add(new Triangle(10));
        geometrylist.add(new Rectangle(10, 5));
        geometrylist.add(new Square(5));

        double sumOfAllCircumfences = 0;
        double sumOfAllAreas = 0;

        for (Geometry geolist : geometrylist) {

            System.out.printf("Area of "+geolist.getClass().getSimpleName()+ " == %.2f " ,geolist.getArea());
            System.out.printf("Circumfence of "+geolist.getClass().getSimpleName()+ " == %.2f " ,geolist.getCircumference());
            System.out.println("\n");

            sumOfAllAreas += geolist.getArea();
            sumOfAllCircumfences += geolist.getCircumference();


        }
        System.out.printf("Sum of all Areas == %.4f", sumOfAllAreas);
        System.out.printf(" Sum of all Circumfences == %.4f" , sumOfAllCircumfences);
    }

}
