package Furkan.week07.Serie;

import Furkan.week07.Person.Human1;

public class AnimeSerie {
    private String title;
    private String genre;
    private int year;
    private String language;

    private Human1 regisseur;
    private Human1 produzent;

    public AnimeSerie(String title, String genre, int year, String language){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.regisseur = null;
        this.produzent = null;
    }

    public boolean hireRegie (Human1 regisseur){
        if(this.regisseur != null){
            System.out.println("Dieser Job ist schon besetzt...");
            return false;
        }
        this.regisseur =regisseur;
        System.out.println(this.regisseur.getFullName() + " ist für das Projekt eingestellt!");
        return true;
    }
    //hire produzent

    //fire regie

    //fire produzent


    //simulation von produktion derSerie



    //entwender toString oder printOut überarbeiten...

    public void printOut(){
        System.out.println("Titel: " + title + " Genre: " + genre + " Ausstrahlungsjahr: " + year + " Originalsprache: " + language +
                           " Der Regisseur ist: " + regisseur + " und Produzent: " + produzent);

    }

    public String toString(){
        return "Titel: " + title + " Genre: " + genre + " Ausstrahlungsjahr: " + year + " Originalsprache: " + language +
               " Der Regisseur ist: " + regisseur + " und Produzent: " + produzent;

    }
}
