package Thiemo.week09.Zoo;

public class ZooMain {
    public static void main(String[] args) {

        Zoo zoo = new Zoo("AnimalKingdom", "Feldkirch", 1996, 10, 1000);

        Enclosure alpMeadow = new Enclosure("Alpmeadow", 20, 10, "Outdoor", 0);
        Enclosure ried = new Enclosure("ried", 15, 10, "Indoor", 1);
        Enclosure aquararium = new Enclosure("Aquarium", 10, 10, "Outdoor", 2);
        Enclosure meadow = new Enclosure("meadow", 30, 20, "Outdoor", 0);
        Enclosure terrarium = new Enclosure("Terrarium", 20, 10, "Indoor", 0);

        Food meat = new Food("meat", "kg", 10);
        Food fruit = new Food("fruit", "kg", 1);
        Food vegetables = new Food("vegetables", "kg", 2);
        Food trash = new Food("Garbage","kg",10);

        Animal croc = new Animal("Crocodile", "Kroko", "male", "Adult", 7, 100, 100, meat, 10);
        Animal tiger = new Animal("Tiger", "Kahn", "male", "Adult", 10, 100, 100, meat, 10);
        Animal chicken = new Animal("Chicken", "Nugget", "male", "child", 0, 10, 10, fruit, 1);
        Animal chicken2 = new Animal("Chicken", "Nugget2", "male", "child", 0, 10, 10, fruit, 1);
        Animal chickenKing = new Animal("Chicken", "King", "male", "adult", 1, 15, 15, fruit, 2);
        Animal chickenSlave = new Animal("Chicken", "Slave", "male", ",adult", 0, 1, 1, fruit, 0.5);
        Animal chickenQueen = new Animal("Chicken", "Queen", "female", "adult", 2, 10, 10, fruit, 2);
        Animal rabbit = new Animal("Rabbit", "Superbit", "male", "adult", 0, 1000, 1000, vegetables, 5);
        Animal pig = new Animal("Pig","Fatty","male","adult",1,50,50,trash,10);

        zoo.addEnclosure(ried);
        zoo.addEnclosure(aquararium);
        zoo.addEnclosure(alpMeadow);
        zoo.addEnclosure(meadow);
        zoo.addEnclosure(terrarium);
        aquararium.addAnimals(croc);
        ried.addAnimals(tiger);
        meadow.addAnimals(chickenKing);
        meadow.addAnimals(chickenQueen);
        meadow.addAnimals(chicken);
        meadow.addAnimals(chicken2);
        meadow.addAnimals(chickenSlave);
        alpMeadow.addAnimals(rabbit);
        terrarium.addAnimals(pig);

        zoo.printZoo();


    }
}
