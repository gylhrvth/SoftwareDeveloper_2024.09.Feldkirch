package Erik.week12.DBSelbsttestMitOOP;

import java.sql.SQLException;

public class ZooStart {
    public static void main(String[] args) throws SQLException {

        // Zoo Objekt(e) erstellen
        Zoo zoo = new Zoo("Otter World", "Ottinistan", 2024);

        // Pfleger Objekte erstellen
        ZooKeeper pflegerTom = new ZooKeeper("Tom", "Schaf");
        ZooKeeper pflegerSelina = new ZooKeeper("Selina", "Delphin");
        ZooKeeper pflegerJack = new ZooKeeper("Jack", "Otter");

        // Tier Arzt Objekt erstellen
        Vet vetOliver = new Vet("Oliver");

        // Gehege Objekte erstellen
        Enclosure freiland = new Enclosure("Freiland Wiese");
        Enclosure aquarium = new Enclosure("Aquarium");
        Enclosure terrarium = new Enclosure("Terrarium");

        // Essen Objekte für Tiere erstellen
        Food fleisch = new Food("Kuhfleisch", 10, 100);
        Food fish = new Food("Forellen", 10, 100);
        Food gras = new Food("Gras", 10, 100);
        Food pflanze = new Food("Wasser Pflanze", 10, 100);

        // Tier Objekte erstellen
//        Animal otter = new Animal("Otter", "Kishi", fish, 20, 1000, 50);
//        Animal schaf = new Animal("Schaf", "Dinnerbone", gras, 10, 150, 17);
//        Animal delphin = new Animal("Delphin", "Rudolf", fish, 50, 250, 14);
//        Animal krokodil = new Animal("Krokodil", "Schnappi", fleisch, 100, 1, 18);
//        Animal fisch = new Animal("Fish", "Robin", pflanze, 5, 50, 2);
//        Animal huhn = new Animal("Huhn", "Max", gras, 5, 100, 2);
//        Animal huhn1 = new Animal("Huhn", "Bella", gras, 5, 100, 2);
//        Animal huhn2 = new Animal("Huhn", "Luna", gras, 5, 100, 2);
//        Animal huhn3 = new Animal("Huhn", "Charlie", gras, 5, 100, 2);
//        Animal huhn4 = new Animal("Huhn", "Daisy", gras, 5, 100, 2);
//        Animal huhn5 = new Animal("Huhn", "Simba", gras, 5, 100, 2);
//        Animal huhn6 = new Animal("Huhn", "Nala", gras, 5, 100, 2);
//        Animal huhn7 = new Animal("Huhn", "Milo", gras, 5, 100, 2);
//        Animal huhn8 = new Animal("Huhn", "Nino", gras, 5, 100, 2);
//        Animal huhn9 = new Animal("Huhn", "Chloe", gras, 5, 100, 2);


        // Selbsttest
        DBManager dbManager = DBManager.getInstance();
        dbManager.getConnection();


        dbManager.readAnimalsFromDB(freiland);



        Animal newAnimal = new Animal("Löwe", "Leo", dbManager.getFoodByName("Meat"), 5, 100, 30);


//            dbManager.insertAnimalToDB(newAnimal);
//            dbManager.updateAnimalInDB(newAnimal);
//            dbManager.deleteAnimalFromDB(newAnimal);

        dbManager.closeConnection();

        // Methoden aufrufen
        // Gehege adden
        zoo.addGehegeInList(freiland);
        zoo.addGehegeInList(aquarium);
        zoo.addGehegeInList(terrarium);


        // Pfleger adden
        zoo.addPfleger(pflegerTom);
        zoo.addPfleger(pflegerSelina);
        zoo.addPfleger(pflegerJack);


        // Den Pflegern die Gehege zuweisen
        pflegerTom.addTask(freiland);
        pflegerSelina.addTask(terrarium);
        pflegerJack.addTask(aquarium);


        // Tier Arzt adden und Gehege zuweisen
        zoo.addVet(vetOliver);

        vetOliver.addTask(freiland);
        vetOliver.addTask(terrarium);
        vetOliver.addTask(aquarium);


        // Tiere adden
        // Freiland
//        freiland.addAnimalToList(schaf);
//        freiland.addAnimalToList(huhn);
//        freiland.addAnimalToList(huhn2);
//        freiland.addAnimalToList(huhn3);
//        freiland.addAnimalToList(huhn4);
//        freiland.addAnimalToList(huhn5);
//        freiland.addAnimalToList(huhn6);
//
//        // Aquarium
//        aquarium.addAnimalToList(otter);
//        aquarium.addAnimalToList(delphin);
//        aquarium.addAnimalToList(fisch);
//
//        // Terrarium
//        terrarium.addAnimalToList(krokodil);
//        freiland.addAnimalToList(huhn7);
//        freiland.addAnimalToList(huhn8);
//        freiland.addAnimalToList(huhn9);
//        freiland.addAnimalToList(huhn1);


//        // Zoo Structure mit Kosten und Simulation Printen
//        zoo.printZooStructure();
//        zoo.printFoodCost();
//        zoo.startTagesSimulation();
    }
}