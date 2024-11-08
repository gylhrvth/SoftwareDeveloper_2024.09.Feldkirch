package Thiemo.week07.Tv;

import Thiemo.week07.LivingBeing.Person;
import Thiemo.week09.Person2.Actor;
import Thiemo.week09.Person2.Human;

import java.util.Random;
import java.util.SequencedCollection;
import java.util.Vector;

public class SerieMain {

    private static Thiemo.week07.LivingBeing.Person Person;

    private static Random random = new Random();

        public static void main(String[] args) {

        Person director = new Person(175, 55, "OG", 60);
        Person producer = new Person(150, 66, "MC", 45);

        Person director1 = new Person(99, 99, "GO", 99);
        Person producer1 = new Person(99, 99, "CM", 99);


        Serie serie50M2 = new Serie("50M2", "Drama", 2021, 2021, "TR", director, producer, 1, 8);
        Serie serieGOT = new Serie("Game of Thrones", "Fantasy", 2011, 2019, "ENG", director1, producer1, 8, 73);


        Actor actor1 = new Actor("T", "W", 20, 2000);
        Actor actor2 = new Actor("A", "E", 21, 2001);
        Actor actor3 = new Actor("S", "R", 22, 2002);
        Actor actor4 = new Actor("D", "T", 23, 2003);
        Actor actor5 = new Actor("F", "Z", 24, 2004);



        System.out.println(serieGOT);
        serie50M2.hireRegisseur(director);
        System.out.println(serieGOT);
        serieGOT.hireWorkers(producer, director);
        System.out.println(serieGOT);
        serie50M2.hireWorkers(producer, director);
        System.out.println(serie50M2);
        serie50M2.hireProducent(producer);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
        serieGOT.hireProducent(producer);
        System.out.println(serieGOT);
        System.out.println(serieGOT);
        serieGOT.hireProducent(producer);
        System.out.println(serieGOT);

        serieGOT.addToScoutList(actor1);
        serieGOT.addToScoutList(actor2);
        serieGOT.addToScoutList(actor3);
        serieGOT.addToScoutList(actor4);
        serieGOT.addToScoutList(actor5);
        System.out.println(serieGOT);

        serieGOT.addToCastList(actor1);
        serieGOT.addToCastList(actor2);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
        serieGOT.addToCastList(actor1);
        serieGOT.addToCastList(actor2);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
        serieGOT.addToCastList(actor1);
        serieGOT.addToCastList(actor2);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
        serieGOT.addToCastList(actor1);
        serieGOT.addToCastList(actor2);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
            Vector<Actor> moreActors = generateRandomActors(10);
            for (Actor a : moreActors){
                serieGOT.addToScoutList(a);
            }
            System.out.println(serieGOT);

            System.out.println(serieGOT.getScoutList().elementAt(5));
            Actor TH = serieGOT.getScoutList().elementAt(5);
            serieGOT.addToCastList(TH);
            System.out.println(serieGOT);

//            Actor young = serieGOT.getScoutList()getAge;
        }




    public static Vector<Actor> generateRandomActors (int count) {
        Vector<Actor> result = new Vector<>();
        String[] firstName = new String[]{"Max", "Jesus", "Akif", "Aylin", "Thiemo", "Furkan", "Erik", "Sandro", "Gyula", "Lukas", "Jessica", "Manfred"};
        String[] surName = new String[]{"Mustermann", "Gotham", "Müller", "Klein", "Gross", "Eichstetter", "Zimmerman", "Topcu", "Horvath", "Boso", "Brechtold", "Wohlgennant", "Tadic"};

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(16, 42);
            int gage = random.nextInt(15000, 20500000);
//            String name = firstName[random.nextInt(firstName.length)] + " " + surName[random.nextInt(surName.length)];
            String firstname = firstName[random.nextInt(firstName.length)];
            String surname = surName[random.nextInt(surName.length)];
            result.add(new Actor(firstname,surname,age, gage));
        }
        return result;
    }

}
