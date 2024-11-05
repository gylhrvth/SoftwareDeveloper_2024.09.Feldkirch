package Thiemo.week07.Tv;

import Thiemo.week07.LivingBeing.Person;

public class Main {
    private static Thiemo.week07.LivingBeing.Person Person;

    public static void main(String[] args) {

        Person regessiuer = new Person(175, 55, "OG", 60);
        Person producent = new Person(150, 66, "MC", 45);

        Person regessiuer1 = new Person(99, 99, "GO", 99);
        Person producent1 = new Person(99, 99, "CM", 99);


        Serie serie50M2 = new Serie("50M2", "Drama", 2021, 2021, "TR", regessiuer, producent, 1, 8);
        Serie serieGOT = new Serie("Game of Thrones", "Fantasy", 2011, 2019, "ENG", regessiuer1, producent1, 8, 73);


        System.out.println(serieGOT);
        serie50M2.hireRegisseur(regessiuer);
        System.out.println(serieGOT);
        serieGOT.hireWorkers(producent,regessiuer);
        System.out.println(serieGOT);
        serie50M2.hireWorkers(producent,regessiuer);
        System.out.println(serie50M2);
        serie50M2.hireProducent(producent);
        System.out.println(serieGOT);
        serieGOT.fireAll();
        System.out.println(serieGOT);
        serieGOT.hireProducent(producent);
        System.out.println(serieGOT);
        System.out.println(serieGOT);
        serieGOT.hireProducent(producent);
        System.out.println(serieGOT);
    }
}
