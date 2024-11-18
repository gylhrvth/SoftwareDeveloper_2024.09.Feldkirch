package Sandro.Week9.ZooTycoon2.ZooTycoon;

public class ZooTycoon {
    public static void main(String[] args) {

        //todo make the print with sleep

        Zoo zoo = new Zoo("WildLife Miami", 2001);

        ZooKeeper keeper1 = new ZooKeeper("Mike");
        ZooKeeper keeper2 = new ZooKeeper("Lila");
        ZooKeeper keeper3 = new ZooKeeper("Sandro");
        ZooKeeper keeper4 = new ZooKeeper("Burt");

        Vet vet1 = new Vet("Dr.Bob Bobster");
        Vet vet2 = new Vet("Dr.Eva Mendez");

        Food food1 = new Food("Weed", "Barrel", 30);
        Food food2 = new Food("Meat", "kg", 10);
        Food food3 = new Food("Mouse", "Piece", 5);

        Enclosure enc1 = new Enclosure(zoo, "Meadow", "Outdoor", "Outside Temperature");
        Enclosure enc2 = new Enclosure(zoo, "Woods", "Outdoor", "Outside Temperature");
        Enclosure enc3 = new Enclosure(zoo, "Reptile Terrarium", "Indoor", "Hot");
        Enclosure enc4 = new Enclosure(zoo, "Fish Tank", "Indoor", "Saltwater");

        Animal animal1 = new Animal("Baeba", "Cow", food1, 2, 100, 300, 20);
        Animal animal2 = new Animal("Daetta", "Bull", food1, 4, 200, 500, 40);
        Animal animal3 = new Animal("Ragna", "Wolf", food2, 3, 120, 250, 60);
        Animal animal4 = new Animal("Lagerta", "Wolf", food2, 3, 100, 200, 40);
        Animal animal5 = new Animal("Basil", "Snake", food3, 5, 60, 100, 30);
        Animal animal6 = new Animal("Medusa", "Snake", food3, 5, 50, 80, 30);
        Animal animal7 = new Animal("Lisa", "Cow", food1, 2, 100, 330, 20);
        Animal animal8 = new Animal("Loco Hombre", "Bull", food1, 4, 200, 550, 40);
        Animal animal9 = new Animal("Bjórn", "Wolf", food2, 3, 120, 240, 60);
        Animal animal10 = new Animal("Harald", "Wolf", food2, 3, 100, 190, 40);
        Animal animal11 = new Animal("Shiva", "Snake", food3, 5, 60, 90, 30);
        Animal animal12 = new Animal("Aldrich", "Snake", food3, 5, 50, 110, 30);

        keeper1.addTask(zoo, enc1);
        keeper1.addTask(zoo, enc2);
        keeper1.addTask(zoo, enc3);
        keeper2.addTask(zoo, enc2);
        keeper2.addTask(zoo, enc3);
        keeper2.addTask(zoo, enc4);
        keeper4.addTask(zoo, enc1);
        keeper4.addTask(zoo, enc2);
        keeper4.addTask(zoo, enc3);
        keeper4.addTask(zoo, enc4);

        zoo.addVet(vet1);
        zoo.addVet(vet2);


        zoo.addenc(enc1);
        enc1.addAnimal(animal1);
        enc1.addAnimal(animal2);
        enc1.addAnimal(animal7);
        enc1.addAnimal(animal8);
        zoo.addenc(enc2);
        enc2.addAnimal(animal3);
        enc2.addAnimal(animal4);
        enc2.addAnimal(animal9);
        enc2.addAnimal(animal10);
        zoo.addenc(enc3);
        enc3.addAnimal(animal5);
        enc3.addAnimal(animal6);
        enc3.addAnimal(animal11);
        enc3.addAnimal(animal12);
        zoo.addenc(enc4);



        zoo.printZoo();
        zoo.printFoodCost();


        System.out.println("_____________________________________________________________________________");
        System.out.println("02.May Tue 7:00 a Clock");
        System.out.println();
        zoo.printTaskprogression(100);
//        zoo.printZoo();
//        zoo.printFoodCost();


    }


}
