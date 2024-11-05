package Thiemo.week07.Tv;

import Thiemo.week07.LivingBeing.Person;

public class Serie {

    private String title;
    private String genre;
    private int startProductionYear;
    private int endProductionyear;
    private String originalLanguage;
    private Person regessiuer;
    private Person producent;
    private int seasons;
    private int episode;

    public Serie(String title, String genre, int productionYear, int endProductionyear, String originalLanguage, Person regessiuer, Person producent, int seasons, int episode) {
        this.title = title;
        this.genre = genre;
        this.startProductionYear = productionYear;
        this.endProductionyear = endProductionyear;
        this.originalLanguage = originalLanguage;
        this.regessiuer = null;
        this.producent = null;
        this.seasons = seasons;
        this.episode = episode;

    }


    public boolean hireWorkers(Person producent, Person regessiuer) {
        if (this.producent != null && this.regessiuer != null) {
            System.out.println("The Positions are already filled\n");
            return false;
        }
        if (this.producent == null) {
            this.producent = producent;
            System.out.println("New producent hired for "+title+" : " + producent.getName() + "\n");
        }
        if (this.regessiuer == null) {
            this.regessiuer = regessiuer;
            System.out.println("New Regisseur hired for "+title+" : " + regessiuer.getName() + "\n");
        }
        return true;
    }


    public void hireProducent(Person producent) {
        if (this.producent != null) {
            System.out.println("Producent for the Series "  + title +" already hired: " + this.producent.getName() + "\n");
        } else {
            this.producent = producent;
            System.out.println("New producent hired for "+title+" : " + producent.getName() + "\n");
        }
    }


    public void hireRegisseur(Person regessiuer) {
        if (this.regessiuer != null) {
            System.out.println("Regisseur for the Series "  + title +" already hired: " + this.regessiuer.getName() + "\n");
        } else {
            this.regessiuer = regessiuer;
            System.out.println("New Regisseur hired for "+title+": " + regessiuer.getName() + "\n");
        }

    }


    public void fireAll() {
        if (producent == null && regessiuer == null) {
            System.out.println("Already empty, can't fire anybody\n");

        } else {
            this.producent = null;
            this.regessiuer = null;
            System.out.println("All workers have been fired.\n");
        }
    }


    @Override
    public String toString() {

        String regessiuerName = (regessiuer != null) ? regessiuer.getName() : "Not assigned";
        String producentName = (producent != null) ? producent.getName() : "Not assigned";

        return " Serie\n" +
                " Title = " + title + "\n" +
                " Genre = " + genre + "\n" +
                " Start ProductionYear = " + startProductionYear + "\n" +
                " End ProductionYear = " + endProductionyear + "\n" +
                " OriginalLanguage = " + originalLanguage + "\n" +
                " Regessiuer = " + regessiuerName + "\n" +
                " Producent = " + producentName + "\n" +
                " Seasons = " + seasons + "\n" +
                " Episode = " + episode + "\n";
    }
}
