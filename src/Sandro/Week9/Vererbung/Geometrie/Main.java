package Sandro.Week9.Vererbung.Geometrie;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        Geo test = new Triagle(10);

       System.out.println("Umfang: "+test.getCircumference());
       System.out.println("Inhalt: "+test.getArea());


       Geo square = new Square(20);



        Vector<Geo> geometryList = new Vector<>();

        int sumOfAllAreas = 0;
        int sumOfAllCircumferences = 0;

        for (Geo g : geometryList) {
            System.out.println("Area of " + g.getClass().getSimpleName() + ": " + g.getArea());
            System.out.println("Circumference of " + g.getClass().getSimpleName() + ": " + g.getCircumference());
            sumOfAllAreas += g.getArea();
            sumOfAllCircumferences += g.getCircumference();
        }
        System.out.println();
        System.out.println("Sum of All");
        System.out.println("All Areas sum: " + sumOfAllAreas);
        System.out.println("All Circumferences sum: " + sumOfAllCircumferences);
        System.out.println();


    }
}
