package Erik.week08.TVSerie2;

import Erik.week07.person.Person;
import Sandro.Colors;

public class TVSerieMain {
    public static void main(String[] args) {

        // Objekte erstellen
        TVSerie series = new TVSerie("How I Met Your Mother", "Romantic, Comedy, Sitcom, Comedy, Drama, Romance", "2005-2014", 9, 208);

        Person regisseurFryman = new Person("Pamela Fryman",65,2,2);
        Person produceFryman = new Person("Pamela Fryman",65,2,2);

        TVActor ted = new TVActor("Josh","Radnor",50,500);
        TVActor marshall = new TVActor("Jason","Segel",44,650);
        TVActor robin = new TVActor("Cobie","Smulders",42,520);
        TVActor barney = new TVActor("Neil Patrick","Harris",51,820);
        TVActor lily = new TVActor("Alyson","Hannigan",50,735);

        // Methoden Aufrufen
        System.out.println("-".repeat(55) + "\n>>TV-Serie<<\n" + "-".repeat(55));
        System.out.println(series);
        System.out.println("═".repeat(55));
        series.hireProduzent(produceFryman);
        series.hireRegisseur(regisseurFryman);
        System.out.println("═".repeat(55));
        System.out.println(series);

        System.out.println("═".repeat(55));
        series.startProduction();                   // Fail

        series.addPeopleToCastList(ted);
        series.addPeopleToCastList(marshall);
        series.addPeopleToCastList(robin);
        series.addPeopleToCastList(barney);
        series.addPeopleToCastList(lily);

        System.out.println("═".repeat(55));
        System.out.println(series);
        System.out.println("═".repeat(55));

        series.addPeopleToActressListAndRemovePeopleFromCastList(ted);
        series.addPeopleToActressListAndRemovePeopleFromCastList(marshall);
        series.addPeopleToActressListAndRemovePeopleFromCastList(robin);
        series.addPeopleToActressListAndRemovePeopleFromCastList(barney);
        series.addPeopleToActressListAndRemovePeopleFromCastList(lily);

        System.out.println(series);
        System.out.println("═".repeat(55));
        series.startProduction();
        System.out.println("═".repeat(55));
        series.throwProduzent(produceFryman);
        series.throwRegisseur(regisseurFryman);

        series.removeActressList(ted);
        series.removeActressList(marshall);
        series.removeActressList(robin);
        series.removeActressList(barney);
        series.removeActressList(lily);
        System.out.println("Alle Schauspieler werden nicht mehr gebraucht und wurden gekündigt");
        System.out.println("═".repeat(55));
        System.out.println(series);





    }
}