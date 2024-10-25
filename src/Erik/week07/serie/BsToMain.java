package Erik.week07.serie;

import Erik.week07.person.Person;

public class BsToMain {
    public static void main(String[] args) {

        /*
        serie 1: Regisseur = "Masaharu Watanabe"      Produzent = "White Fox"
        serie 2: Regisseur = "Fukuda Michio"          Produzent = "Seven Arcs"
        serie 3: Regisseur = "Yoshiki Yamakawa"       Produzent = "J.C.Staff"
         */

        // Objekt erstellen / (Serie erstellen)
        BsTo animeSerie1 = new BsTo("Re Zero | Re: Zero Kara Hajimeru Isekai Seikatsu", "Re:Zero", "Action, Drama, Mystery, Abenteuer, Fantasy", 3, 54, "2016-Unbekannt", "Masahiro Yokotani");
        BsTo animeSerie2 = new BsTo("Hazurewaku no Joutai Ijou Skill | Failure Frame", "Failure Frame", "Horror, Action, Drama, Comedy, Abenteuer, Ecchi", 1, 12, "2024-Unbekannt", "Nakanishi Yasuhiro");
        BsTo animeSerie3 = new BsTo("Dungeon ni Deai | Danmachi Try to pick up Girls in a Dungeon", "Danmachi", "Action, Comedy, Romantik, Abenteuer, Fantasy", 5, 62, "2015-Unbekannt", "Hideki Shirane");

        Person regisseurWatanabe = new Person("Masaharu Watanabe",2,2,2);
        Person produzentFox = new Person("White Fox",2,2,2);

        // Methoden Aufruf (Serien Auflistung)
        System.out.println("-".repeat(55) + "\n>>Anime-Serie 1<<\n" + "-".repeat(55));
        System.out.println(animeSerie1);
        System.out.println("═".repeat(55));
        animeSerie1.hireProduzent(produzentFox);
        System.out.println(animeSerie1 + "\n");
        animeSerie1.hireRegisseur(regisseurWatanabe);
        System.out.println(animeSerie1 + "\n");
        animeSerie1.throwProduzent(produzentFox);
        System.out.println(animeSerie1 + "\n");
        animeSerie1.throwRegisseur(regisseurWatanabe);
        System.out.println(animeSerie1 + "\n" + "-".repeat(55));

// Das, selbe wie oben nochmal hier unten machen vllt mit zusatz das (Produktion erst startet, wenn Regisseur und Produzent vorhanden sind mit kleiner kostenrechnung)
        System.out.println("-".repeat(55) + "\n>>Anime-Serie 2<<\n" + "-".repeat(55));
        System.out.println(animeSerie2);
        System.out.println("═".repeat(55));
        System.out.println("-".repeat(55) + "\n>>Anime-Serie 3<<\n" + "-".repeat(55));
        System.out.println(animeSerie3);
        System.out.println("═".repeat(55));

    }
}
