package Erik.week08.Zoo;

public class ZooStart {
    public static void main(String[] args) {

        // Zoo Objekt(e) erstellen
        Zoo zoo = new Zoo("Otter World", "Ottinistan", 2024);

        // Pfleger Objekte erstellen
        Pfleger pflegerTom = new Pfleger("Tom");
        Pfleger pflegerSelina = new Pfleger("Selina");

        // Gehege Objekte erstellen
        Gehege Freiland = new Gehege("Freiland Wiese");
        Gehege Aquarium = new Gehege("Aquarium");
        Gehege Terrarium = new Gehege("Terrarium");

        // Essen Objekte für Tiere erstellen
        Essen Fleisch = new Essen("Kuhfleisch", 10, 100);
        Essen Fish = new Essen("Forellen", 10, 100);
        Essen Gras = new Essen("Gras", 10, 100);
        Essen Pflanze = new Essen("Wasser Pflanze", 10, 100);

        // Tier Objekte erstellen
        Tier Otter = new Tier("Otter", "Kishi", Fish, 20);
        Tier Schaf = new Tier("Schaf", "Dinnerbone", Gras, 10);
        Tier Delphin = new Tier("Delphin", "Rudolf", Fish, 50);
        Tier Krokodil = new Tier("Krokodil", "Schnappi", Fleisch, 100);
        Tier Fisch = new Tier("Fish", "Robin", Pflanze, 5);


        // Methoden aufrufen
        // Gehege adden
        zoo.addGehegeInList(Freiland);
        zoo.addGehegeInList(Aquarium);
        zoo.addGehegeInList(Terrarium);

        // Den Pflegern die Gehege zuweisen
        zoo.addPfleger(pflegerTom);
        zoo.addPfleger(pflegerSelina);
        pflegerTom.addTask(Freiland);
        pflegerTom.addTask(Aquarium);
        pflegerSelina.addTask(Terrarium);

        // Tiere adden
        Aquarium.addTiereToTierList(Otter);
        Freiland.addTiereToTierList(Schaf);
        Aquarium.addTiereToTierList(Delphin);
        Terrarium.addTiereToTierList(Krokodil);
        Aquarium.addTiereToTierList(Fisch);

        // Zoo Structure mit Kosten und Simulation Printen
        zoo.printZooStructure();
        zoo.printFoodCost();
        zoo.startSimulation();
    }
}