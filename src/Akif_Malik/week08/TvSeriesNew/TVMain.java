package Akif_Malik.week08.TvSeriesNew;

import Sandro.Week7.Human.Person;
import Sandro.Week7.TVSeries.TVSerie;

public class TVMain {
    public static void main(String[] args) {
        //--Serie
        TVSerie serie1 = new TVSerie("The Life and Movies of Ersan Kuneri", "Drama", 2022, "Türkisch", 28);

        //--Personen
        Person regisseurTarantino = new Person("Quentin", "Tarantino", 55, "Male", 189, 89);
        Person produzent1 = new Person("Stanly", "Kubrik", 78, "Male", 170, 78);
        Person regisseur2 = new Person("Steven", "Spielberg", 65, "Male", 189, 89);
        Person produzentGuyla = new Person("Gyula", "Horvath", 78, "Male", 170, 78);
    }
}

