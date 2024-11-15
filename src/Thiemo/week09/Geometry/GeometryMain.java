package Thiemo.week09.Geometry;

import java.util.Vector;

public class GeometryMain {
    public static void main(String[] args) {

        Vector<Geometry> geometrylist = new Vector<>();

        geometrylist.add(new Circle(5));
        geometrylist.add(new Triangle(10));
        geometrylist.add(new Rectangle(10, 5));
        geometrylist.add(new Square(5));

        int sumOfAllCircumfences = 0;
        int sumOfAllAreas = 0;

        for (Geometry geolist : geometrylist) {

            System.out.println("Area of "+geolist.getClass().getSimpleName()+ " == " +geolist.getArea());
            System.out.println("Circumfence of "+geolist.getClass().getSimpleName()+ " == " +geolist.getCircumference()+"\n");

            sumOfAllAreas += geolist.getArea();
            sumOfAllCircumfences += geolist.getCircumference();


        }
        System.out.println("Sum of all Areas == "+ sumOfAllAreas);
        System.out.println("Sum of all Circumfences == " + sumOfAllCircumfences);
    }

}
