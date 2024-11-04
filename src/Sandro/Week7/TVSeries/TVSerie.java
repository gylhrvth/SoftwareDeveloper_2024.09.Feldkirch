package Sandro.Week7.TVSeries;

import Sandro.Colors;
import Sandro.Week7.Human.Person;

public class TVSerie {

    private String titel;
    private String gerne;
    private int year;
    private String language;
    private int episodes;

    private Person regisseur;
    private Person produzent;


    public TVSerie(String titel, String gerne, int year, String language, int episodes) {
        this.titel = titel;
        this.gerne = gerne;
        this.year = year;
        this.language = language;
        this.episodes = episodes;
        this.produzent = null;
        this.regisseur = null;
    }


    //Funktion erstellen mit public boolean (Attribute attribute)
    //check if this.attribute != null
    //if this.attribute is null /Empty
    //this.attribute = attribute
    //return True
    public boolean hireProduction(Person produzent) {
        if (this.produzent != null) {
            System.out.println("There is already a Production working on the Project");
            return false;
        }
        this.produzent = produzent;
        System.out.println(this.produzent.getFullName() + " ... is hired for the Project!");
        return true;
    }

    /*
    public boolean hireRegisseur(Person regisseur) {
        if (this.regisseur != null) {
            System.out.println("There is already a Regisseur working on the Project");
            return false;
        }
        this.regisseur = regisseur;
        System.out.println(this.regisseur.getFullName() + " ... is hired for the Project!");
        return true;
    }

     */
    public void hireTest(Person regisseur) {
        if (this.regisseur != null) {
            System.out.println("There is already a Regisseur working on the Project");
        } else {
            this.regisseur = regisseur;
            System.out.println(this.regisseur.getFullName() + " ... is hired for the Project!");
        }

    }

    //Funktion erstellen public Person fireRegisseur
    //Person regsisseur = this.regisseur
    //sout
    //this.regisseur = null
    //return regisseur
    public Person fireProduzent() {
        Person produzent = this.produzent;
        System.out.println(this.produzent.getFullName() + " ... was fired after bad Work!");
        this.produzent = null;
        return produzent;
    }

    public Person fireRegisseur() {
        Person regisseur = this.regisseur;
        System.out.println(Colors.COLORS[1] + regisseur.getFullName() + " was fired from the Project!" + Colors.RESET);
        this.regisseur = null;
        return regisseur;
    }

    public void hireAllJobs(Person x, Person y){
        hireProduction(x);
        hireTest(y);

    }

    public void fireAll() {
        fireRegisseur();
        fireProduzent();
    }

    public void startProduction() {
        if (this.regisseur == null) {
            System.out.println("Production can not start, without any Regisseur...");
            return;
        }
        if (this.produzent == null) {
            System.out.println("Production can not start, without any Production...");
            return;
        }

        for (int i = 0; i < episodes; i++) {
            System.out.println("Day (" + i + ") ...working progress...");
        }

        System.out.println("Production finished");
        System.out.println(titel);
        System.out.println("Episodes: " + episodes);
        System.out.println("Budget: " + episodes * 12 + "$");

    }


    public String toString() {
        String regName = "Unknown";
        String prodName = "Unknown";

        if (regisseur != null) {
            regName = this.regisseur.getFullName();
        }
        if (produzent != null) {
            prodName = this.produzent.getFullName();
        }

        return "Title: " + titel + "\nGerne: " + gerne + "\nYear: " + year + "\nLanguage: " + language + "\nRegie: " + regName + "\nProduction: " + prodName;

    }

}
