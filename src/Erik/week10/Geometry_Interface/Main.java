package Erik.week10.Geometry_Interface;

import Erik.week09.Geometry.Circle;
import Erik.week09.Geometry.Geometry;
import Erik.week09.Geometry.Rectangle;
import Erik.week09.Geometry.Square;
import Erik.week09.Geometry.Triangle;
import Sandro.Colors;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Objekt erstellen
        Rectangle rectangle = new Rectangle(10, 20);
        Square square = new Square(10);
        Circle circle = new Circle(4);
        Triangle triangle = new Triangle(30, 20, 50, 40);


        // Liste erstellen und befüllen
        Vector<Geometry> geo = new Vector<>();

        geo.add(rectangle);
        geo.add(square);
        geo.add(circle);
        geo.add(triangle);


        // Gesamt, Umfang und Fläche berechnen
        double totalCircumference = 0;
        double totalArea = 0;

        for (Geometry g : geo) {
            totalCircumference += g.getCircumference();
            totalArea += g.getArea();
        }

        System.out.println("Gesamt Umfang von allen Geometrien: >> " + Colors.COLORS[1] + totalCircumference + Colors.RESET);
        System.out.println("Gesamt Fläche von allen Geometrien: >> " + Colors.COLORS[1] + totalArea + Colors.RESET);
    }
}