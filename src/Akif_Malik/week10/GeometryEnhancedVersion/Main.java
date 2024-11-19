package Akif_Malik.week10.GeometryEnhancedVersion;

public class Main {
    public static void main(String[] args) {

        Geo NikolausHaus = new HausVomNikolaus();

        System.out.println();

        System.out.println("Circumference of Haus vom Nikolaus: " + NikolausHaus.getCircumference());
        System.out.println("Area of Haus vom Nikolaus: " + NikolausHaus.getArea());

        Geo KompassStern = new KompassStern();

        System.out.println();

        System.out.println("Area of Kompass Stern: " + KompassStern.getArea());
        System.out.println("Circumference of Kompass Stern: " + KompassStern.getCircumference());
    }
}
