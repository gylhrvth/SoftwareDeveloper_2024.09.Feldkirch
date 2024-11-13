package Furkan.week09.Zoo;

public class MainZoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Muntafuner Zoo" , 2022);
        Gehege wald = new Gehege("Wald");
        Gehege safari = new Gehege("Safari" );
        Gehege hof = new Gehege("Hof");
        Gehege aquarium = new Gehege("Aquarium" );

        Food hay = new Food("Heu" , "kg" , 14);
        Food meat = new Food("Fleisch" , "kg" , 46);
        Food fruit = new Food("Früchte" , "kg" , 16);



        Tier esel = new Tier("Esek" , "Esel" , hay , 3);
        Tier pferd = new Tier("Asena" , "Pferd" , hay , 5);
        Tier katze = new Tier("Garfield" , "Katze" , meat , 1);
        Tier hund = new Tier("Memoli", "Hund" , meat , 3);
        Tier papagei= new Tier("Orhan" ,"Papagei", fruit, 3);
        Tier elefant = new Tier("Ayki", "Elefant" , fruit,  7);
        Tier bear = new Tier("Yogi" , "Bär" , meat , 14);
        Tier krokodile = new Tier("Mr.Crocodile","Krokodile" , meat , 7);
        Tier giraffe = new Tier("Pipilangstrumpf" , "Giraffe" , fruit , 8);

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


        zoo.searchAndCreateZooKeeper("Coban Aykut", "Wald");
        zoo.searchAndCreateZooKeeper("Göki", "Safari");
        zoo.searchAndCreateZooKeeper("Herbert" , "Hof");
        zoo.searchAndCreateZooKeeper("Herman" , "Aquarium");






        zoo.printZoo();
        zoo.printFoodCost();
        zoo.startSimu(7);




    }
}
