package Akif_Malik.week10.GeometrieInterface;

public class Main {
    public static void main(String[] args) {

        Geo tester = new Rectangle(5,15);

        System.out.println(tester.getCircumference());
        System.out.println(tester.getArea());

        Geo test = new Triangle(8);

        System.out.println();

        System.out.println(test.getCircumference());
        System.out.println(test.getArea());
    }
}
