package Thiemo.week07.Tv;

import Thiemo.week07.LivingBeing.Person;
import Thiemo.week09.Person2.Actor;

import java.util.Random;
import java.util.Vector;

public class Serie {
    private static Random random = new Random();


    private String title;
    private String genre;
    private int startProductionYear;
    private int endProductionyear;
    private String originalLanguage;
    private Person director;
    private Person producer;
    private int seasons;
    private int episode;
    private Vector<Actor> scoutList;
    private Vector<Actor> castList;


    public Serie(String title, String genre, int startProductionYear, int endProductionyear, String originalLanguage, Person director, Person producer, int seasons, int episode) {
        this.title = title;

        this.genre = genre;
        this.startProductionYear = startProductionYear;
        this.endProductionyear = endProductionyear;
        this.originalLanguage = originalLanguage;
        this.director = director;
        this.producer = producer;
        this.seasons = seasons;
        this.episode = episode;
        this.scoutList = new Vector<>();
        this.castList = new Vector<>();
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Serie.random = random;
    }

    public Vector<Actor> getScoutList() {
        return scoutList;
    }

    public void setScoutList(Vector<Actor> scoutList) {
        this.scoutList = scoutList;
    }

    public Vector<Actor> getCastList() {
        return castList;
    }

    public void setCastList(Vector<Actor> castList) {
        this.castList = castList;
    }

    public boolean hireWorkers(Person producent, Person regessiuer) {
        if (this.producer != null && this.director != null) {
            System.out.println("The Positions are already filled\n");
            return false;
        }
        if (this.producer == null) {
            this.producer = producent;
            System.out.println("New producent hired for " + title + " : " + producent.getName() + "\n");
        }
        if (this.director == null) {
            this.director = regessiuer;
            System.out.println("New Regisseur hired for " + title + " : " + regessiuer.getName() + "\n");
        }
        return true;
    }


    public void hireProducent(Person producent) {
        if (this.producer != null) {
            System.out.println("Producent for the Series " + title + " already hired: " + this.producer.getName() + "\n");
        } else {
            this.producer = producent;
            System.out.println("New producent hired for " + title + " : " + producent.getName() + "\n");
        }
    }


    public void hireRegisseur(Person regessiuer) {
        if (this.director != null) {
            System.out.println("Regisseur for the Series " + title + " already hired: " + this.director.getName() + "\n");
        } else {
            this.director = regessiuer;
            System.out.println("New Regisseur hired for " + title + ": " + regessiuer.getName() + "\n");
        }

    }


    public void fireAll() {
        if (producer == null && director == null && castList.isEmpty()) {
            System.out.println("Already empty, can't fire anybody\n");

        } else {
            this.producer = null;
            this.director = null;
            scoutList.addAll(castList);
            this.castList.clear();


            System.out.println("All workers have been fired.\n");
        }

    }

    public void addToScoutList(Actor person) {
        if (scoutList.contains(person)) {
            return;
        }
        scoutList.add(person);
    }

    public void addToCastList(Actor person) {
        int count = 0;
        if (castList.contains(person)) {
            return;
        } else {
            castList.add(person);
            count = person.getCount();
            person.setCount(count + 1);
            scoutList.remove(person);
            if (count >= 3) {
                castList.remove(person);
            }
        }
    }

    @Override
    public String toString() {

        String regessiuerName = (director != null) ? director.getName() : "Not assigned";
        String producentName = (producer != null) ? producer.getName() : "Not assigned";

        return " Serie\n" +
                " Title = " + title + "\n" +
                " Genre = " + genre + "\n" +
                " Start ProductionYear = " + startProductionYear + "\n" +
                " End ProductionYear = " + endProductionyear + "\n" +
                " OriginalLanguage = " + originalLanguage + "\n" +
                " Regessiuer = " + regessiuerName + "\n" +
                " Producent = " + producentName + "\n" +
                " Seasons = " + seasons + "\n" +
                " Episode = " + episode + "\n" +
                " Scoutlist = " + scoutList + "\n" +
                " Castlist = " + castList + "\n";
    }
}
