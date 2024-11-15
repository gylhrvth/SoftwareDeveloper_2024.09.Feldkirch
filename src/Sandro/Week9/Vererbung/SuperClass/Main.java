package Sandro.Week9.Vererbung.SuperClass;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lebewesen erstellen");
        Lebenswesen lebe = new Lebenswesen("bob", 15);
        System.out.println("###################");
        System.out.println();

        System.out.println("Mensch erstellen");
        Mensch mensch = new Mensch("mike", 23, "male");
        System.out.println("###################");
        System.out.println();
        System.out.println("Tier erstellen");
        Tier tier = new Tier("Susi", 3, "Hund");
        System.out.println("###################");
        System.out.println();
        System.out.println("Hund erstellen");
        Hund hund = new Hund("Rex", 5, "Hund", "Braun", true);
        System.out.println("###################");
        System.out.println();
        System.out.println("Schäferhund erstellen");
        Schäferhund schäfer = new Schäferhund("Max", 7, "Hund", "Weiß", false, "spitze Ohren");
        System.out.println("###################");
        System.out.println();
        mensch.grow();

        //objekt mit toString ist redundant, unnötig weil das printen vom Ojekt automatisch die toString funktion aufruft.

        Vector<Lebenswesen> test = new Vector<>();


        Vector<Lebenswesen> LebeListe = new Vector<>();

        LebeListe.add(lebe);
        LebeListe.add(tier);
        LebeListe.add(mensch);
        LebeListe.add(hund);
        LebeListe.add(schäfer);


        System.out.println("##################################");
        for (Lebenswesen l : LebeListe) {
            System.out.println("Objekt print   -->" + l);
            System.out.println("Get Class      --> " + l.getClass());
            System.out.println("Get simpleName --> " + l.getClass().getSimpleName());
            System.out.println();
        }




    }
}
