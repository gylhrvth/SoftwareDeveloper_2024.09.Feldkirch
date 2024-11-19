package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo tiergartenDornbirn = new Zoo("Tiergarten Dornbirn", 2022);

        Enclosure alpenwiese = new Enclosure("Alpenwiese");
        Enclosure ried = new Enclosure("Ried");
        Enclosure terrarium = new Enclosure("Terrarium (warm)");

        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Nuggets", "chicken", "♂", 200, 10);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Tatar", "beef","♂", 200, 100);
        tiergartenDornbirn.searchAndCreateAnimal("Savanna", "Steak", "beef", "♀", 100, 5);
        tiergartenDornbirn.searchAndCreateAnimal("Aquarium", "Nemo", "guppy", "♀", 10, 1);


        tiergartenDornbirn.searchAndCreateZooKeeper("Akif", "Aquarium", "chicken");
        tiergartenDornbirn.searchAndCreateZooKeeper("Enes", "Savanna", "chicken");

        tiergartenDornbirn.addGehege(alpenwiese);
        tiergartenDornbirn.addGehege(ried);
        tiergartenDornbirn.addGehege(terrarium);

        //tiergartenDornbirn.printStructure();

        for (int day = 1; day <10 ; day++) {
            tiergartenDornbirn.simulateDay(day);
            System.out.println();
        }
    }
}
