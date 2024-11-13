package Thiemo.week09.Zoo;

import Sandro.Colors;

public class ZooMain {
    public static void main(String[] args) {

        Zoo zoo = new Zoo("AnimalKingdom", "Feldkirch", 1996, 1000);

        Enclosure alpMeadow = new Enclosure("Alpmeadow", 20, "Outdoor");
        Enclosure ried = new Enclosure("Ried", 15, "Indoor");
        Enclosure aquararium = new Enclosure("Aquarium", 10, "Outdoor");
        Enclosure meadow = new Enclosure("Meadow", 30, "Outdoor");
        Enclosure terrarium = new Enclosure("Terrarium", 20, "Indoor");

        Food meat = new Food("meat", "kg", 10);
        Food fruit = new Food("fruit", "kg", 1);
        Food vegetables = new Food("vegetables", "kg", 2);
        Food trash = new Food("Garbage", "kg", 0);

        Animal croc = new Animal("Crocodile", "Kroko", "male", "Adult", 7, 1000, 1000,99, meat, 10);
        Animal tiger = new Animal("Tiger", "Kahn", "male", "Adult", 9, 1000, 1000,99, meat, 10);
        Animal chicken = new Animal("Chicken", "Nugget", "male", "child", 1, 100, 100,10, fruit, 1);
        Animal chicken2 = new Animal("Chicken", "Nugget2", "male", "child", 1, 100, 100,10, fruit, 1);
        Animal chickenKing = new Animal("Chicken", "King", "male", "adult", 1, 150, 150,15, fruit, 2);
        Animal chickenSlave = new Animal("Chicken", "Slave", "male", ",adult", 1, 11, 11,50, trash, 0.5);
        Animal chickenQueen = new Animal("Chicken", "Queen", "female", "adult", 2, 100,100, 10, fruit, 2);
        Animal rabbit = new Animal("Rabbit", "Superbit", "male", "adult", 0, 1000,1000, 1000, vegetables, 5);
        Animal pig = new Animal("Pig", "Fatty", "male", "adult", 4, 500,500, 50, trash, 10);

        Zookeeper keeper1 = new Zookeeper("Mike", "Male", 25, 100, 100, 2,"Kahn");
        Zookeeper keeper2 = new Zookeeper("Dan", "Male", 40, 80, 50, 2,"Chicken");
        Zookeeper keeper3 = new Zookeeper("Lisa", "Female", 30, 100, 70, 1,"Superbit");


        zoo.addEnclosure(ried);
        zoo.addEnclosure(aquararium);
        zoo.addEnclosure(alpMeadow);
        zoo.addEnclosure(meadow);
        zoo.addEnclosure(terrarium);


        zoo.addKeeper(keeper1);
        zoo.addKeeper(keeper2);
        zoo.addKeeper(keeper3);


        aquararium.addAnimals(croc);
        ried.addAnimals(tiger);
        meadow.addAnimals(chickenKing);
        meadow.addAnimals(chickenQueen);
        meadow.addAnimals(chicken);
        meadow.addAnimals(chicken2);
        meadow.addAnimals(chickenSlave);
        alpMeadow.addAnimals(rabbit);
        terrarium.addAnimals(pig);


        keeper1.addEnclosureTasks(ried);
        keeper1.addEnclosureTasks(alpMeadow);
        keeper1.addEnclosureTasks(terrarium);
        keeper2.addEnclosureTasks(ried);
        keeper2.addEnclosureTasks(meadow);
        keeper3.addEnclosureTasks(aquararium);
        keeper3.addEnclosureTasks(alpMeadow);


        zoo.printZoo();
        zoo.printFoodStats();


        for (int day = 1; day < 100; day++) {
            System.out.println("\n"+Colors.COLORS[3]+ "Daily Work Starts || Day:" + day + Colors.RESET+"\n");
            zoo.simulateDay(day);
            System.out.println();
        }
    }
}
