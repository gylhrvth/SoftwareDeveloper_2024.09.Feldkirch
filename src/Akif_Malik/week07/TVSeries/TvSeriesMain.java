package Akif_Malik.week07.TVSeries;

import Akif_Malik.week07.Human.Person;
import Sandro.Colors;

public class TvSeriesMain {

    public static void main(String[] args) {

        Person regisseurShunsuke = new Person("Shunsuke", "Ishikawa", 39, "Male", 185, 83);
        Person produzentTetsuaki = new Person("Tetsuaki", "Watanabe", 74, "Male", 177, 70);

        TvSeries tv2 = new TvSeries("Blue Lock", 24, "Japanese", 2, 2023, "Anime Shōnen Soccer Animation Sport Thriller", regisseurShunsuke, produzentTetsuaki);

        System.out.println(Colors.COLORS[7] + "Information about the Serie: \n" + Colors.RESET + Colors.COLORS[5] + tv2 + Colors.RESET);

        hireRegisseur(regisseurShunsuke);
        hireProduzent(produzentTetsuaki);
        fireRegisseur(regisseurShunsuke);

        System.out.println(Colors.COLORS[4] + "-#-#-#-#-#-#-#-#-#-#-#-#-#-#-" + Colors.RESET);
        System.out.println(Colors.COLORS[3] + "Episodes made: " + tv2.getFolgen());
        System.out.println("Seasons made: " + tv2.getStaffel());
        System.out.println("Episodes per season: " + tv2.getFolgen() / 2 + Colors.RESET);
    }

    public static void hireProduzent(Person produzent1) {
        if (produzent1 == null) {
            System.out.println(Colors.COLORS[1] + "Produktion kann nicht ohne produzent gestartet werden!" + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[2] + produzent1.getFullName() + " got hired as produzent....." + Colors.RESET);
            System.out.println(Colors.COLORS[5] + "Working on the Project...." + Colors.RESET);
            for (int i = 0; i < 11; ) {
                System.out.println(Colors.COLORS[6] + "DAY: " + i + Colors.RESET);
                i++;
            }
            System.out.println(Colors.COLORS[2] + "Project has been finished!!" + Colors.RESET);
        }
    }

    public static void hireRegisseur(Person regisseur1) {
        if (regisseur1 == null) {
            System.out.println(Colors.COLORS[1] + "Produktion kann ohne regisseur nicht gestartet werden!" + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[2] + regisseur1.getFullName() + " got hired as regisseur....." + Colors.RESET);
        }
    }

    public static void fireRegisseur(Person regisseur) {
        if (regisseur != null) {
            System.out.println(Colors.COLORS[1] + "The current regisseur has been fired..." + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[1] + "There is no available regisseur to be fired...." + Colors.RESET);
        }
    }

    public static void fireProduzent(Person produzent) {
        if (produzent == null) {
            System.out.println(Colors.COLORS[1] + "The current produzent has been fired...." + Colors.RESET);
        } else {
            System.out.println(Colors.COLORS[1] + "There is no available produzent to be fired..." + Colors.RESET);
        }
    }
}


