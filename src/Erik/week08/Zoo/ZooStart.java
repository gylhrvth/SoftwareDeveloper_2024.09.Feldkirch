package Erik.week08.Zoo;

public class ZooStart {
    public static void main(String[] args) {

        // Objekte erstellen

        // Zoo Objekt(e) erstellen
        Zoo zoo = new Zoo("Otter World", "Ottinistan", 2024);

        // Pfleger Objekte erstellen
        Pfleger pflegerTom = new Pfleger("Tom");
        Pfleger pflegerSelina = new Pfleger("Selina");

        // Gehege Objekte erstellen
        Gehege ghFreiland = new Gehege("Freiland Wiese");
        Gehege ghAquarium = new Gehege("Aquarium");
        Gehege ghTerrarium = new Gehege("Terrarium");

        // Essen Objekte für Tiere erstellen
        Essen Fleisch = new Essen("Kuhfleisch", 10, 100);
        Essen Fish = new Essen("Forellen", 10, 100);
        Essen Gras = new Essen("Gras", 10, 100);
        Essen Pflanze = new Essen("Wasser Pflanze", 10, 100);

        // Tier Objekte erstellen
        Tier tiOtter = new Tier("Otter", "Kishi", Fish, 20);
        Tier tiSchaf = new Tier("Schaf", "Dinnerbone", Gras, 10);
        Tier tiDelphin = new Tier("Delphin", "Rudolf", Fish, 50);
        Tier tiKrokodil = new Tier("Krokodil", "Schnappi", Fleisch, 100);
        Tier tiFish = new Tier("Fish", "Robin", Pflanze, 5);


        // Methoden aufrufen
        // Gehege adden
        zoo.addGehegeInList(ghFreiland);
        zoo.addGehegeInList(ghAquarium);
        zoo.addGehegeInList(ghTerrarium);

        // Den Pflegern die Gehege zuweisen
        pflegerTom.addTask(ghFreiland);
        pflegerTom.addTask(ghAquarium);
        pflegerSelina.addTask(ghTerrarium);

        // Tiere adden
        ghAquarium.addTiereToTierList(tiOtter);
        ghFreiland.addTiereToTierList(tiSchaf);
        ghAquarium.addTiereToTierList(tiDelphin);
        ghTerrarium.addTiereToTierList(tiKrokodil);
        ghAquarium.addTiereToTierList(tiFish);

        // Zoo Structure mit Kosten und Simulation Printen
        zoo.printZooStructure();
        zoo.printFoodCost();
        zoo.startSimulation();


    }
}