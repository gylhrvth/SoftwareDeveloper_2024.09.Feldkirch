package Furkan.week07.Serie;

import Furkan.week07.Person.Human1;

public class main {
    public static void main(String[] args) {
        AnimeSerie animeSerie1 = new AnimeSerie("One Piece", "Anime,Abenteuer" , 1999,
                            "Japanisch" );

        //Personen erstellen für jobs
        Human1 regieShanks = new Human1("Red Hair","Shanks","Red Hair Shanks",39,199,79, 4_000_000_000L);

        //Regisseur
        //Produzent




        //Verlauf
        //start.Produktion
        //wenn Produzent oder Regie nicht besetzt, kein start...
        //wenn beides true... fori Schleife
        //verschiedne Situationen
        //hire, fire, print serie... zum testen

        animeSerie1.printOut();
        animeSerie1.hireRegie(regieShanks);
        animeSerie1.hireRegie(regieShanks);
        animeSerie1.printOut();

    }
}
