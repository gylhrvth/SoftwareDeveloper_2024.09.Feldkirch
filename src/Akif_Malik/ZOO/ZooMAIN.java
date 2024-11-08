package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo NewYorkZoo = new Zoo("New York Zoo", 2023);

        Gehege Alpenwiese = new Gehege("Alpenwiese");
        Gehege Ried = new Gehege("Ried");
        Gehege Terrarium = new Gehege("Terrarium ((warm))");

        Tiere Rijska = new Tiere("Rijska", "Kuh");

        Tiere Garmond = new Tiere("Garmond", "Storch");
        Tiere Hugo = new Tiere("Hugo", "Storch");
        Tiere Idaxis = new Tiere("Idaxis", "Storch");

        Tiere leer = new Tiere("leer", "");

        Essen brot = new Essen("bread");
        Essen kuhfleisch = new Essen("beef");
        Essen fisch = new Essen("fish");

        //----------Gehegen---------\\
        NewYorkZoo.addGehege(Alpenwiese);
        NewYorkZoo.addGehege(Ried);
        NewYorkZoo.addGehege(Terrarium);
        //----------Tiere-----------\\
        NewYorkZoo.addTieren(Rijska);
        NewYorkZoo.addTieren(Garmond);
        NewYorkZoo.addTieren(Hugo);
        NewYorkZoo.addTieren(Idaxis);
        NewYorkZoo.addTieren(leer);
        //----------Essen----------\\
        NewYorkZoo.addFoods(brot);
        NewYorkZoo.addFoods(kuhfleisch);
        NewYorkZoo.addFoods(fisch);
        //---------COMMANDS---------\\
        System.out.println(NewYorkZoo);
    }
}
