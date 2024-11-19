package Akif_Malik.week10.GeometryEnhancedVersion;

public class Main {
    public static void main(String[] args) {

        Geo NikolausHaus = new HausVomNikolaus(5);

        System.out.println();

        System.out.println("Circumference of Haus vom Nikolaus: " + NikolausHaus.getCircumference());
        System.out.println("Area of Haus vom Nikolaus: " + NikolausHaus.getArea());

        Geo KompassStern = new KompassStern(5);

        Geo t = new Triangle(5);

        System.out.println();

        //System.out.println(t.getArea());

        System.out.println("Area of Kompass Stern: " + KompassStern.getArea());
        System.out.println("Circumference of Kompass Stern: " + KompassStern.getCircumference());
    }
}
