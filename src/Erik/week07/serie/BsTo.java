package Erik.week07.serie;

import Erik.week07.person.Person;
import Sandro.Colors;

public class BsTo {

    // Attribute
    private String fullTitle;
    private String shortTitel;
    private String genre;
    private int seasons;
    private int currentEpisodes;
    private String productionYears;
    private Person produzent;
    private Person regisseur;
    private String autors;

    // Konstruktor
    public BsTo(String fullTitle, String shortTitel, String genre, int seasons, int currentEpisodes, String productionYears, String autors) {
        this.fullTitle = fullTitle;
        this.shortTitel = shortTitel;
        this.genre = genre;
        this.seasons = seasons;
        this.currentEpisodes = currentEpisodes;
        this.productionYears = productionYears;
        this.produzent = null;     // Produzent, ist am Anfang unbekannt deswegen "null"
        this.regisseur = null;     // Regisseur, ist am Anfang unbekannt deswegen "null"
        this.autors = autors;
    }

    // Getter - Setter

    public Person getProduzent(Person produzent) {
        return produzent;
    }

    public Person getRegisseur(Person regisseur) {
        return regisseur;
    }

    // Methoden
    @Override
    public String toString() {

        String regisseurName = "Unbekannt";
        String produzentName = "Unbekannt";

        if (regisseur != null){
            regisseurName = this.regisseur.getName();
        }
        if (produzent != null){
            produzentName = this.produzent.getName();
        }

        return "Ganzer Titel: >> " + fullTitle +
                "\nTitel gekürzt: >> " + shortTitel +
                "\nGenre: >> " + genre +
                "\nStaffeln: >> " + seasons +
                "\nAktuelle Episoden: >> " + currentEpisodes +
                "\nProduktionsjahre: >> " + productionYears +
                "\nProduzent: >> " + produzentName +
                "\nRegisseur: >> " + regisseurName +
                "\nAutor: >> " + autors;
    }


    public boolean hireProduzent(Person produzent) {
        this.produzent = produzent;
        System.out.println(Colors.COLORS[2] + "Produzent " + getProduzent(produzent) + " wurde eingestellt\n" + Colors.RESET);
        return true;
    }

    public boolean hireRegisseur(Person regisseur) {
        this.regisseur = regisseur;
        System.out.println(Colors.COLORS[2] + "Regisseur " + getRegisseur(regisseur) + " wurde eingestellt\n" + Colors.RESET);
        return true;
    }


    public boolean throwProduzent(Person produzent){
        this.produzent = null;
        System.out.println(Colors.COLORS[1] + "Produzent " + getProduzent(produzent) + " wurde rausgeschmissen! Serie ist fertig.\n" + Colors.RESET);
        return true;
    }

    public boolean throwRegisseur(Person regisseur){
        this.regisseur = null;
        System.out.println(Colors.COLORS[1] + "Regisseur " + getProduzent(regisseur) + " wurde rausgeschmissen! Serie ist fertig.\n" + Colors.RESET);
        return true;
    }

}