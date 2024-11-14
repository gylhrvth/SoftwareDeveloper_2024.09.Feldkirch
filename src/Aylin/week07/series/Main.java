package Aylin.week07.series;

import Aylin.week07.human.Human;
import Aylin.week08.SeriesActors.SeriesActors;
import org.w3c.dom.ls.LSOutput;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        //Series
        Series serie1 = new Series("Adanalı", "crime drama", 2008, "Türkiye", 3, 90);
        Series serie2 = new Series("Yargı", "drama", 2021, "Türkiye", 3, 95);
        Series serie3 = new Series("Doktorlar", "medical drama", 2006, "America", 4, 97);

        //People
        Human directorBilgin = new Human("Ali", "Bilgin", 43, 181);
        Human directorBilgeCeylan = new Human("Nuri", "Bilge Ceylan", 64, 180);
        Human directorSpielberg = new Human("Steven", "Spielberg", 77, 173);
        Human directorCurtiz = new Human("Michael", "Curtiz", 75, 175);
        Human directorTopcu = new Human("Aygün", "Topcu", 26, 178);

        Human producerRhimes = new Human("Shonda", "Rhimes", 54, 170);
        Human producerMurphy = new Human("Ryan", "Murphy", 58, 183);
        Human producerKorkmaz = new Human("Serkan", "Korkmaz", 46, 179);
        Human producerKaradeniz = new Human("Burak", "Karadeniz", 24, 176);
        Human producerBerben = new Human("Oliver", "Berben", 53, 184);

        Human writerErgenekon = new Human("Sema", "Ergenekon", 46, 172);
        Human writerApuhan = new Human("Irem", "Apuhan", 27, 165);
        Human writerSorkin = new Human("Aaron", "Sorkin", 62, 180);
        Human writerTykwer = new Human("Tom", "Tykwer", 58, 180);
        Human writerRhimes = producerRhimes;

        String[] name = new String[]{"Dwayne", "Tom", "Leonardo", "Brad", "Robert", "Elyas", "Matthias", "Idris", "Henry", "Kıvanç", "Burak", "Çağatay"};
        String[] surname = new String[]{"Johnson", "Cruise", "DiCaprio", "Pitt", "Downey Jr.", "M'Barek", "Schweighöfer", "Elba", "Cavill", "Tatlıtuğ", "Özçivit", "Ulusoy"};
        int[] age = new int[]{52, 62, 49, 60, 59, 42, 42, 52, 41, 41, 39, 34};
        int[] fee = new int[]{22, 15, 20, 22, 20, 2, 3, 13, 15, 2, 2, 2};

        for (int i = 0; i < name.length; i++) {
            String actorName = name[i];
            String actorSurname = surname[i];
            int actorAge = age[i];
            int actorFee = fee[i];
            serie2.addScout(new SeriesActors(actorName, actorSurname, actorAge, actorFee));
        }

        //Printing the lists
        Series.printScoutList(serie2.getScoutList());
        System.out.println("==================");
        Series.printCastList(serie2.getCastList());
        System.out.println("==================");

        // Hiring staff for series
        serie2.hireDirector(directorTopcu);
        serie2.hireProducer(producerKaradeniz);
        serie2.hireWriter(writerApuhan);
        serie2.hireCast(serie2.getScoutList().firstElement());
//        Series.printCastList(serie2.getCastList());
//        Series.printScoutList(serie2.getScoutList());

        //start Production
        for (int i = 1; i <= 10 ; i++) {
            serie2.startProduction(i);
        }
    }
}
