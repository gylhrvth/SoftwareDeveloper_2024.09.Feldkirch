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

        // Tier Arzt Objekt erstellen
        TierArzt vetOliver = new TierArzt("Oliver");

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
        Tier otter = new Tier("Otter", "Kishi", fish, 20, 1000, 50);
        Tier schaf = new Tier("Schaf", "Dinnerbone", gras, 10, 150, 17);
        Tier delphin = new Tier("Delphin", "Rudolf", fish, 50, 250, 14);
        Tier krokodil = new Tier("Krokodil", "Schnappi", fleisch, 100, 1, 18);
        Tier fisch = new Tier("Fish", "Robin", pflanze, 5, 50, 2);
        Tier huhn = new Tier("Huhn", "Max",gras,5,100,2);
        Tier huhn1 = new Tier("Huhn", "Bella",gras,5,100,2);
        Tier huhn2 = new Tier("Huhn", "Luna",gras,5,100,2);
        Tier huhn3 = new Tier("Huhn", "Charlie",gras,5,100,2);
        Tier huhn4 = new Tier("Huhn", "Daisy",gras,5,100,2);
        Tier huhn5 = new Tier("Huhn", "Simba",gras,5,100,2);
        Tier huhn6 = new Tier("Huhn", "Nala",gras,5,100,2);
        Tier huhn7 = new Tier("Huhn", "Milo",gras,5,100,2);
        Tier huhn8 = new Tier("Huhn", "Nino",gras,5,100,2);
        Tier huhn9 = new Tier("Huhn", "Chloe",gras,5,100,2);



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
        freiland.addTiereToTierList(schaf);
        freiland.addTiereToTierList(huhn);
        freiland.addTiereToTierList(huhn2);
        freiland.addTiereToTierList(huhn3);
        freiland.addTiereToTierList(huhn4);
        freiland.addTiereToTierList(huhn5);
        freiland.addTiereToTierList(huhn6);

        // Aquarium
        aquarium.addTiereToTierList(otter);
        aquarium.addTiereToTierList(delphin);
        aquarium.addTiereToTierList(fisch);

        // Terrarium
        terrarium.addTiereToTierList(krokodil);
        freiland.addTiereToTierList(huhn7);
        freiland.addTiereToTierList(huhn8);
        freiland.addTiereToTierList(huhn9);
        freiland.addTiereToTierList(huhn1);


        // Zoo Structure mit Kosten und Simulation Printen
        zoo.printZooStructure();
        zoo.printFoodCost();
        zoo.startTagesSimulation();


        // Tier arzt bekommt liste
        // Tier arzt geht die Liste von Gehegen durch
        // Geht, die Tier liste mit Tieren durch
        // Geht durch alle gehege durch und sucht sich das tier mit der geringsten HP
        // nächste Gehege nächstes Tier
        // ...
        // Die ausgesuchten Tiere miteinander vergleichen und das mit der geringsten HP speichern

        // die hp vor dem heilen wird angezeigt
        // das angepeilte tier wird geheilt
        // die hp nach dem heilen wird angezeigt

    }
}