package Thiemo.week10.GeometryInterface;

import Sandro.Colors;

import java.util.Vector;

public class GeometryMain {
    public static void main(String[] args) {

        Vector<Geometry> geometryList = new Vector<>();

        geometryList.add(new Circle(5));
        geometryList.add(new Triangle(10));
        geometryList.add(new Rectangle(10, 5));
        geometryList.add(new Square(5));

        int sumOfAllCircumfences = 0;
        int sumOfAllAreas = 0;

        for (Geometry geolist : geometryList) {

            System.out.println("Area of "+geolist.getClass().getSimpleName()+ " == " +geolist.getArea());
            System.out.println("Circumfence of "+geolist.getClass().getSimpleName()+ " == " +geolist.getCircumference()+"\n");

            sumOfAllAreas += geolist.getArea();
            sumOfAllCircumfences += geolist.getCircumference();


        }
        System.out.printf("Sum of all Areas == %d", sumOfAllAreas);
        System.out.printf(" Sum of all Circumfences == %d" , sumOfAllCircumfences);
    }

}
