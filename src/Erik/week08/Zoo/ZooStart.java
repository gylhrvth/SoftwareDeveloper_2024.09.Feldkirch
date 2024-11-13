package Erik.week08.Zoo;

import Sandro.Colors;

public class ZooStart {
    public static void main(String[] args) {

        // Zoo Objekt(e) erstellen
        Zoo zoo = new Zoo("Otter World", "Ottinistan", 2024);

        // Pfleger Objekte erstellen
        Pfleger pflegerTom = new Pfleger("Tom", "Schaf");
        Pfleger pflegerSelina = new Pfleger("Selina", "Delphin");
        Pfleger pflegerJack = new Pfleger("Jack", "Otter");

        // Gehege Objekte erstellen
        Gehege freiland = new Gehege("Freiland Wiese");
        Gehege aquarium = new Gehege("Aquarium");
        Gehege terrarium = new Gehege("Terrarium");

        // Essen Objekte für Tiere erstellen
        Essen fleisch = new Essen("Kuhfleisch", 10, 100);
        Essen fish = new Essen("Forellen", 10, 100);
        Essen gras = new Essen("Gras", 10, 100);
        Essen pflanze = new Essen("Wasser Pflanze", 10, 100);

        // Tier Objekte erstellen
        Tier otter = new Tier("Otter", "Kishi", fish, 20);
        Tier schaf = new Tier("Schaf", "Dinnerbone", gras, 10);
        Tier delphin = new Tier("Delphin", "Rudolf", fish, 50);
        Tier krokodil = new Tier("Krokodil", "Schnappi", fleisch, 100);
        Tier fisch = new Tier("Fish", "Robin", pflanze, 5);


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


        // Tiere adden
        aquarium.addTiereToTierList(otter);
        freiland.addTiereToTierList(schaf);
        aquarium.addTiereToTierList(delphin);
        terrarium.addTiereToTierList(krokodil);
        aquarium.addTiereToTierList(fisch);


        // Zoo Structure mit Kosten und Simulation Printen
        zoo.printZooStructure();
        zoo.printFoodCost();

        System.out.println(Colors.COLORS[3] + "Simulation des Zoo's wird gestartet: ..." + Colors.RESET);
        for (int tag = 1; tag <= 3; tag++) {
            System.out.println(Colors.COLORS[1] + "Tag: >> " + tag + " <<" + Colors.RESET);
            zoo.startTagesSimulation();
        }
    }
}