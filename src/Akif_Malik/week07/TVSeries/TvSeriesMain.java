package Akif_Malik.week07.TVSeries;

import Akif_Malik.week07.Human.Person;
import Sandro.Colors;

import java.awt.*;

public class TvSeriesMain {

    public static void main(String[] args) {

        //TvSeries tv1 = new TvSeries("Story", 0, "English", 0, 0, "not given");

        Person regisseur1 = new Person("Shunsuke", "Ishikawa", 39, "Male", 185, 83);
        Person produzent1 = new Person("Tetsuaki", "Watanabe", 74, "Male", 177, 70);

        TvSeries tv2 = new TvSeries("Blue Lock", 24, "Japanese", 2, 2023, "Anime Shōnen Soccer Animation Sport Thriller", regisseur1, produzent1);


        //System.out.println("Information about the Serie: \n" + tv1);
        //System.out.println();

        System.out.println("Information about the Serie: \n" + tv2);

        hireRegisseur(regisseur1);
        hireProduzent(produzent1);
        System.out.println("-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
        System.out.println("Episodes made: " + tv2.getFolgen());
        System.out.println("Seasons made: " + tv2.getStaffel());


    }
    public static void hireProduzent(Person produzent1) {
        if (produzent1 == null) {
            System.out.println(Colors.COLORS[1] +"Produktion kann nicht ohne produzent gestartet werden!" + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[2] +"Tetsuaki Watanabe got hired as produzent....."+ Colors.RESET);
            System.out.println("Working on the Project....");
            for (int i = 0; i < 11; ) {
                System.out.println("DAY: " + i);
                i++;
            }
            System.out.println("Project has been finished!!");
        }
    }

    public static void hireRegisseur(Person regisseur1) {
        if (regisseur1 == null) {
            System.out.println(Colors.COLORS[1] + "Produktion kann ohne regisseur nicht gestartet werden!" + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[2] + "Shunsuke Ishikawa got hired as regisseur....." + Colors.RESET);
        }
    }
}


