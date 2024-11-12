package Erik.week08.Zoo;

public class ZooStart {
    public static void main(String[] args) {

        // Zoo Objekt(e) erstellen
        Zoo zoo = new Zoo("Otter World", "Ottinistan", 2024);

        // Pfleger Objekte erstellen
        Pfleger pflegerTom = new Pfleger("Tom");
        Pfleger pflegerSelina = new Pfleger("Selina");

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

        // Den Pflegern die Gehege zuweisen
        zoo.addPfleger(pflegerTom);
        zoo.addPfleger(pflegerSelina);
        pflegerTom.addTask(freiland);
        pflegerTom.addTask(aquarium);
        pflegerSelina.addTask(terrarium);

        // Tiere adden
        aquarium.addTiereToTierList(otter);
        freiland.addTiereToTierList(schaf);
        aquarium.addTiereToTierList(delphin);
        terrarium.addTiereToTierList(krokodil);
        aquarium.addTiereToTierList(fisch);

        // Zoo Structure mit Kosten und Simulation Printen
        zoo.printZooStructure();
        zoo.printFoodCost();
        zoo.startSimulation();
    }
}