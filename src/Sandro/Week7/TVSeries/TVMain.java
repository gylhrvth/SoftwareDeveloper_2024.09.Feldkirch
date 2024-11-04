package Sandro.Week7.TVSeries;

import Sandro.Week7.Human.Person;
import org.w3c.dom.ls.LSOutput;

import java.text.DateFormat;

public class TVMain {
    public static void main(String[] args) {
        //Serie
        TVSerie serie1 = new TVSerie("The Life and Movies of Ersan Kuneri", "Drama", 2022, "Türkisch", 28);

        //Personen
        Person regisseurTarantino = new Person("Quentin", "Tarantino", 55, "Male", 189, 89);
        Person produzent1 = new Person("Stanly", "Kubrik", 78, "Male", 170, 78);
        Person regisseur2 = new Person("Steven", "Spielberg", 65, "Male", 189, 89);
        Person produzentGuyla = new Person("Gyula", "Horvath", 78, "Male", 170, 78);



        System.out.println(serie1);
        serie1.startProduction();
        System.out.println("-------------");
        serie1.hireTest(regisseurTarantino);
        System.out.println(serie1);
        serie1.startProduction();
        System.out.println("-------------");
        serie1.hireProduction(produzent1);
        serie1.startProduction();
        System.out.println(serie1);
        System.out.println("-------------");
        serie1.hireProduction(produzentGuyla);
        serie1.fireProduzent();
        System.out.println(".....");
        System.out.println(serie1);
        serie1.hireProduction(produzentGuyla);
        System.out.println(serie1);
        //serie1.fireAll();
        //System.out.println(serie1);
        produzentGuyla.setSurName("Boso");
        System.out.println(serie1);


    }


}
