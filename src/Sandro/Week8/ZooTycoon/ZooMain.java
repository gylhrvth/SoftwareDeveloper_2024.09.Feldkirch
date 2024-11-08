package Sandro.Week8.ZooTycoon;

public class ZooMain {
    public static void main(String[] args) {

        Zoo zoo = new Zoo("WildLife Resort", "Ney York",1998);

        Enclosure meadow1 = new Enclosure("Meadow", "18°C","Outdoor");
        Enclosure forest1 = new Enclosure("Forest", "15°C","Outdoor");
        Enclosure fishtank = new Enclosure("FishTank", "22°C","Indoor");

        Food hay = new Food("Hay","kg",12);
        Food meat = new Food("Meat", "kg", 54);
        Food fruit = new Food("Fruit","kg", 8);

        Animal moose1 = new Animal("Rudolf", 4,"Moose",fruit,8);
        Animal moose2 = new Animal("Berta", 6,"Moose",hay,7);
        Animal wolf1 = new Animal("Ragna", 3,"Greywolf",meat, 10);
        Animal wolf2 = new Animal("Lagerta", 7,"Greywolf",meat,12);
        Animal shark1 = new Animal("Hai'nz", 10, "Greatwhite Shark",meat,45);
        Animal shark2 = new Animal("Mike", 10, "Greatwhite Shark",meat,78);

        zoo.addEnclosure(meadow1);
        zoo.addEnclosure(forest1);
        zoo.addEnclosure(fishtank);

        meadow1.addAnimal(moose1);
        meadow1.addAnimal(moose2);
        forest1.addAnimal(wolf1);
        forest1.addAnimal(wolf2);
        fishtank.addAnimal(shark1);
        fishtank.addAnimal(shark2);

        zoo.printZooStructure();
        zoo.printFoodCost();
        zoo.startSimu();









    }
}
