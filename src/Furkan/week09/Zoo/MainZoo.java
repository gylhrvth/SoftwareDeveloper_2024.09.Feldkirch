package Furkan.week09.Zoo;

public class MainZoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Muntafuner Zoo" , 2022);
        Gehege wald = new Gehege("Wald"," im freien");
        Gehege safari = new Gehege("Safari" , " grün");
        Gehege hof = new Gehege("Hof", " Bauernhof");
        Gehege aquarium = new Gehege("Aquarium" , " Süßwasser");

        Tier esel = new Tier("Esek" , "Esel");
        Tier pferd = new Tier("Asena" , "Pferd");
        Tier katze = new Tier("Garfield" , "Katze");
        Tier hund = new Tier("Memoli", "Hund");
        Tier papagei= new Tier("Orhan" ,"Papagei");
        Tier elefant = new Tier("Ayki", "Elefant");
        Tier bear = new Tier("Yogi" , "Bär");
        Tier krokodile = new Tier("Mr.Crocodile","Krokodile");
        Tier giraffe = new Tier("Pipilangstrumpf" , "Giraffe");


        wald.addTier(pferd);
        hof.addTier(esel);
        hof.addTier(katze);
        hof.addTier(hund);
        safari.addTier(papagei);
        wald.addTier(elefant);
        wald.addTier(bear);
        aquarium.addTier(krokodile);
        wald.addTier(giraffe);



        zoo.addGehege(wald);
        zoo.addGehege(safari);
        zoo.addGehege(hof);
        zoo.addGehege(aquarium);


        zoo.printZoo();


    }
}
