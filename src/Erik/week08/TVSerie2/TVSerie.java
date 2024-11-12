package Erik.week08.TVSerie2;

import Erik.week07.person.Person;
import Sandro.Colors;

import java.util.Vector;

public class TVSerie {

    // Attribute
    private String title;
    private String genre;
    private String productionYears;
    private int seasons;
    private int episodes;
    private Person produce;
    private Person regisseur;
    private Vector<String> castList;
    private Vector<String> actressList;


    // Konstruktor
    public TVSerie(String title, String genre, String productionYears, int seasons, int episodes) {
        this.title = title;
        this.genre = genre;
        this.productionYears = productionYears;
        this.seasons = seasons;
        this.episodes = episodes;
        this.produce = null;
        this.regisseur = null;
        this.actressList = new Vector<>();
        this.castList = new Vector<>();
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
        String produceName = "Unbekannt";

        if (regisseur != null) {
            regisseurName = this.regisseur.getName();
        }
        if (produce != null) {
            produceName = this.produce.getName();
        }

        return "Ganzer Titel: >> " + title +
                "\nGenre: >> " + genre +
                "\nStaffeln: >> " + seasons +
                "\nEpisoden: >> " + episodes +
                "\nProduktionsjahre: >> " + productionYears +
                "\nProduzent: >> " + produceName +
                "\nRegisseur: >> " + regisseurName +
                "\nCast List: >> " + castList +
                "\nActress List: >> " + actressList;

    }


    public boolean hireProduzent(Person produzent) {
        this.produce = produzent;
        System.out.println(Colors.COLORS[2] + "Produzent " + getProduzent(produzent) + " wurde eingestellt" + Colors.RESET);
        return true;
    }

    public boolean hireRegisseur(Person regisseur) {
        this.regisseur = regisseur;
        System.out.println(Colors.COLORS[2] + "Regisseur " + getRegisseur(regisseur) + " wurde eingestellt" + Colors.RESET);
        return true;
    }


    public boolean throwProduzent(Person produzent){
        this.produce = null;
        System.out.println(Colors.COLORS[1] + "Produzent " + getProduzent(produzent) + " wurde rausgeschmissen! Serie ist fertig." + Colors.RESET);
        return true;
    }

    public boolean throwRegisseur(Person regisseur){
        this.regisseur = null;
        System.out.println(Colors.COLORS[1] + "Regisseur " + getProduzent(regisseur) + " wurde rausgeschmissen! Serie ist fertig." + Colors.RESET);
        return true;
    }


    public void addPeopleToCastList(TVActor actor) {
        if (!castList.contains(actor)) {
            castList.add(actor.getFullName());
        }
    }

    public void addPeopleToActressListAndRemovePeopleFromCastList(TVActor actor) {
        if (!actressList.contains(actor)) {
            actressList.add(actor.getFullName());
        }
        if (actressList.contains(actor.getFullName())) {
            castList.remove(actor.getFullName());
        }
    }

    public void removeActressList(TVActor actor){
        if (actressList.contains(actor.getFullName())) {
            actressList.remove(actor.getFullName());
        }
    }

    public void startProduction() {
        // produce nicht null und regisseur nicht null und actressList nicht Leer, ist soll er starten
        if ((produce != null) && (regisseur != null) && (!actressList.isEmpty())) {
            int days = 5;

            System.out.println(Colors.COLORS[2] + "Alle stellen besetzt Serie kann beginnen!\n" + Colors.RESET);

            for (int day = 1; day <= days; day++) {
                System.out.println("Tag " + day + " Dreh abgeschlossen");
            }
            System.out.println("Kompletter Dreh abgeschlossen");
            System.out.println("Kündige alle Leute ...");


        } else {
            System.out.println(Colors.COLORS[1] + "Produktion kann nicht gestartet werden" + Colors.RESET);
        }

    }
}