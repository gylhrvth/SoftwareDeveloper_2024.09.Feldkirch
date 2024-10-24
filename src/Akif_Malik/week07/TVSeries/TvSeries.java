package Akif_Malik.week07.TVSeries;

import Akif_Malik.week07.Human.Person;

public class TvSeries {

    private String titel;

    private int Folgen;

    private String sprache;

    private int Staffel;

    private int jahr;

    private String genre;

    private Person regisseur;

    private Person produzent;


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


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getFolgen() {
        return Folgen;
    }

    public void setFolgen(int folgen) {
        Folgen = folgen;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public int getStaffel() {
        return Staffel;
    }

    public void setStaffel(int staffel) {
        Staffel = staffel;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //-------------------------------------------------------------------------------------\\

    @Override
    public String toString() {
        return "Title: " + titel + "\nEpisodes: " + Folgen + "\nLanguage: " + sprache + "\nSeasons: " + Staffel + "\nYear: " + jahr + "\nGenre: " + genre + "\n -------------------------" +"\nRegisseur: \n" + regisseur + "\n -------------------------" +"\nProduzent: \n" + produzent + "\n -------------------------";
    }

}


   