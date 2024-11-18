package Erik.week10.Geometry_Enhanced;

import Sandro.Colors;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Objekte erstellen
        // Nikolaus Haus
        HouseFromNikolaus nikHouse = new HouseFromNikolaus(10);
        Triangle triangleHome = new Triangle(10);
        Square squareHome = new Square(10);

        // Kompass Stern
        KompassStar compStar = new KompassStar(10);
        Square squareStar = new Square(5);
        Triangle triangle = new Triangle(10);


        // Liste erstellen und befüllen
        Vector<IGeometry> geoHome = new Vector<>();

        geoHome.add(triangleHome);
        geoHome.add(squareHome);
        geoHome.add(nikHouse);

        Vector<IGeometry> geoStar = new Vector<>();

        geoStar.add(squareStar);
        geoStar.add(triangle);
        geoStar.add(compStar);


        // Liste durchgehen und Umfang und Flächen berechnen
        double totalCircumferenceHome = 0;
        double totalAreaHome = 0;

        double totalCircumferenceStar = 0;
        double totalAreaStar = 0;

        for (IGeometry g : geoHome) {
            totalCircumferenceHome += g.getCircumference();
            totalAreaHome += g.getArea();
        }

        for (IGeometry g : geoStar){
            totalCircumferenceStar += g.getCircumference();
            totalAreaStar += g.getArea();
        }

        System.out.println(">> Geometrie vom Nikolaus Haus <<");
        System.out.println("Gesamt Umfang von allen Geometrien: >> " + Colors.COLORS[1] + totalCircumferenceHome + Colors.RESET);
        System.out.println("Gesamt Fläche von allen Geometrien: >> " + Colors.COLORS[1] + totalAreaHome + Colors.RESET);

        System.out.println("-".repeat(50));

        System.out.println(">> Geometrie vom Kompass Stern << ");
        System.out.println("Gesamt Umfang von allen Geometrien: >> " + Colors.COLORS[1] + totalCircumferenceStar + Colors.RESET);
        System.out.println("Gesamt Fläche von allen Geometrien: >> " + Colors.COLORS[1] + totalAreaStar + Colors.RESET);

        System.out.println("-".repeat(50));
    }
}