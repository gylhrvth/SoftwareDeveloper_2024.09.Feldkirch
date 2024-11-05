package Akif_Malik.week07.TVSeries;

import Akif_Malik.week07.Human.Person;
import Sandro.Colors;

public class TvSeries {

    private String titel;

    private int Folgen;

    private String sprache;

    private int Staffel;

    private int jahr;

    private String genre;

    private Person regisseur;

    private Person produzent;


    //----------------------------------------------------------------------------------------\\

    public TvSeries(String titel, int Folgen, String sprache, int Staffel, int jahr, String genre, Person regisseur, Person produzent) {
        this.titel = titel;
        this.Folgen = Folgen;
        this.sprache = sprache;
        this.Staffel = Staffel;
        this.jahr = jahr;
        this.genre = genre;
        this.regisseur = regisseur;
        this.produzent = produzent;
    }

    //----------------------------------------------------------------------------------------\\

    public int getFolgen() {
        return Folgen;
    }

    public int getStaffel() {
        return Staffel;
    }

      //---------------------------------------------------------------------------------\\
     //-----------------------------------------------------------------------------------\\
    //-------------------------------------------------------------------------------------\\

    @Override
    public String toString() {
        return "Title: " + titel +
                "\nEpisodes: " + Folgen +
                "\nLanguage: " + sprache +
                "\nSeasons: " + Staffel +
                "\nYear: " + jahr +
                "\nGenre: " + genre +
                Colors.COLORS[4] + "\n -------------------------" + Colors.RESET +
                Colors.COLORS[3] + "\nRegisseur: \n" + regisseur + Colors.RESET +
                Colors.COLORS[4] + "\n -------------------------" + Colors.RESET +
                Colors.COLORS[3] + "\nProduzent: \n" + produzent + Colors.RESET +
                Colors.COLORS[4] + "\n -------------------------" + Colors.RESET;
    }
}


   