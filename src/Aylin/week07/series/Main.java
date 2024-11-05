package Aylin.week07.series;

import Aylin.week07.human.Human;
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


        // Hiring staff for series
        serie2.hireDirector(directorTopcu);
        serie2.hireProducer(producerKaradeniz);
        serie2.hireWriter(writerApuhan);
        System.out.println(serie2);
//        serie2.fireDirector();
        for (int i = 1; i <= 6 ; i++) {
            serie2.startProduction(i);
            if(i == 6){
                serie2.deadWriter();
            }
        }
    }
}
