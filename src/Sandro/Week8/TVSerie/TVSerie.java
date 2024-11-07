package Sandro.Week8.TVSerie;


import Sandro.Colors;

import java.util.Vector;

public class TVSerie {
    private String name;
    private String gerne;
    private int year;
    private TVRegisseur regisseur;
    private Vector<TVSchauspieler> schauspielerListe;
    private Vector<TVSchauspieler> scoutingListe;

    public TVSerie(String name, String gerne, int year) {
        this.name = name;
        this.gerne = gerne;
        this.year = year;
        this.regisseur = null;
        this.schauspielerListe = new Vector<>();
        this.scoutingListe = new Vector<>();
    }

    public boolean hireRegisseur(TVRegisseur regisseur) {
        //check if this.attribute != null
        if (this.regisseur != null) {
            System.out.println("there is already a Regisseur working on the Project");
        }
        //if this.attribute is null /Empty
        //this.attribute = attribute
        this.regisseur = regisseur;
        System.out.println("Regisseur: " + this.regisseur + "   #" + Colors.COLORS[2] + " hired!" + Colors.RESET);
        //return True
        return true;
    }

    public TVRegisseur fireRegisseur() {
        TVRegisseur regisseur = this.regisseur;
        System.out.println("Regisseur: " + this.regisseur + "   #" + Colors.COLORS[1] + " has been fired" + Colors.RESET);
        this.regisseur = null;
        return regisseur;
    }

    public Vector<TVSchauspieler> getScoutingListe() {
        return scoutingListe;
    }

    public void addSchauspieler (TVSchauspieler schauspieler){
        if(!schauspielerListe.contains(schauspieler)){
            schauspielerListe.add(schauspieler);
            scoutingListe.remove(schauspieler);
        }


    }
    public void addScouting (TVSchauspieler schauspieler){
        if(!scoutingListe.contains(schauspieler)){
            scoutingListe.add(schauspieler);
        }

    }
    public void removeScouting (TVSchauspieler schauspieler){
        scoutingListe.remove(schauspieler);
    }
    public void fireSchauspieler (TVSchauspieler schauspieler){
        schauspielerListe.remove(schauspieler);
    }

    public void startProduction() {
        if (regisseur == null) {
            System.out.println("cannot work without a Regisseur");
            return;
        } else if (schauspielerListe.size() == 0) {
            System.out.println("cannot work without a Cast");
            return;
        }

        System.out.println("Production starts at ...");
        int sum = 0;
        for (int i = 0; i < 120; i++) {
            if (i % 14 == 0 && i != 0) {
                System.out.println("Payment requiered: " + sum + ".000 $");
            }

            if(i == 80){
                for (int j = 0; j < schauspielerListe.size(); j++) {

                    if(schauspielerListe.elementAt(j).getSurName() == "Boso"){
                        System.out.println(schauspielerListe.elementAt(j).getSurName() + " was fired from Set");
                        schauspielerListe.remove(schauspielerListe.elementAt(j));

                        TVSchauspieler newActor = scoutingListe.firstElement();
                        addSchauspieler(newActor);
                        System.out.println("The Production has hired \"" +newActor + "\", for the Movie!");
                    }
                }
            }

            if (i % 17 == 0) {
                System.out.println(Colors.COLORS[1] + "Day(" + i + ") ... stop production" + Colors.RESET);
                for (TVSchauspieler schauspieler : schauspielerListe) {
                    sum += schauspieler.getPayCheck();
                }

            } else {
                System.out.println("Day(" + i + ") ... working production");
            }
        }
        int sumTotal = sum + (regisseur.getPayCheck() * 2);

        System.out.println("The Movie is Finished!!!");
        System.out.println("Total cost of the Movie: " + sumTotal + ".000 $");

    }


    @Override
    public String toString() {
        return "Name: " + name +
                "\nGerne: " + gerne +
                "\nYear: " + year +
                "\nRegie: " + regisseur +
                "\nCast: " + schauspielerListe;
    }
}
