package Sandro.Week9.Vererbung.Abstraktion;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        //Vierbeiner vier = new Vierbeiner("test",2,4);

        Vierbeiner hund = new Hund("Bello",5,4,"Wau Wau");
        Vierbeiner katze = new Katze("Mauzi", 3, 4,"Miau");
        Vector<Vierbeiner> list = new Vector<>();

        katze.eats();
        katze.sleeps();

        hund.sleeps();
        hund.eats();



    }
}
