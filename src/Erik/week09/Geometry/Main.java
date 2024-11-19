package Erik.week09.Geometry;

import Sandro.Colors;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Objekt erstellen
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(5);
        Circle circle = new Circle(2);
        Triangle triangle = new Triangle(30, 20, 50, 40);


        // Methoden aufrufen
        System.out.println("─".repeat(20));

        System.out.println("Umfang Rechteck");
        System.out.println(Colors.COLORS[1] + rectangle.getCircumference() + Colors.RESET);
        System.out.println("Fläche Rechteck");
        System.out.println(Colors.COLORS[1] + rectangle.getArea() + Colors.RESET);

        System.out.println("─".repeat(20));

        System.out.println("Umfang Quadrat");
        System.out.println(Colors.COLORS[1] + square.getCircumference() + Colors.RESET);
        System.out.println("Fläche Quadrat");
        System.out.println(Colors.COLORS[1] + square.getArea() + Colors.RESET);

        System.out.println("─".repeat(20));

        System.out.println("Umfang Kreis");
        System.out.println(Colors.COLORS[1] + circle.getCircumference() + Colors.RESET);
        System.out.println("Fläche Kreis");
        System.out.println(Colors.COLORS[1] + circle.getArea() + Colors.RESET);

        System.out.println("─".repeat(20));

        System.out.println("Umfang Dreieck");
        System.out.println(Colors.COLORS[1] + triangle.getCircumference() + Colors.RESET);
        System.out.println("Fläche Dreieck");
        System.out.println(Colors.COLORS[1] + triangle.getArea() + Colors.RESET);

        System.out.println("─".repeat(20));


        Vector<Geometry> geometries = new Vector<>();

        geometries.add(rectangle);
        geometries.add(square);
        geometries.add(circle);
        geometries.add(triangle);

        double totalCircumference = 0;
        double totalArea = 0;

        // Gesamt, Umfang und Fläche berechnen
        for (Geometry g : geometries) {
            totalCircumference += g.getCircumference();
            totalArea += g.getArea();
        }

        System.out.println("Gesamt Umfang von allen Geometrien: >> " + Colors.COLORS[1] + totalCircumference + Colors.RESET);
        System.out.println("Gesamt Fläche von allen Geometrien: >> " + Colors.COLORS[1] + totalArea + Colors.RESET);
    }
}
