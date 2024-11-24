package Aylin.week10.Museum;

import Gyula.week08.Human.Human2;

import java.util.Random;
import java.util.Vector;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        Museum museum = new Museum("Louvre", 1793);

        //Defining rooms
        Showroom room1 = new Showroom("Room 1");
        Showroom room2 = new Showroom("Room 2");
        Showroom room3 = new Showroom("Room 3");
        Showroom room4 = new Showroom("Room 4");
        Showroom room5 = new Showroom("Room 5");
        Showroom room6 = new Showroom("Room 6");
        Showroom room7 = new Showroom ("Room 7");
        Corridor corridor1 = new Corridor("Corridor 1");
        Corridor corridor2 = new Corridor("Corridor 2");
        Room entrance = new Room("Entrance");

        //Add next Room to each other - kinda like a door
        entrance.addNextRoom(corridor1);

        corridor1.addNextRoom(entrance);
        corridor1.addNextRoom(room1);
        corridor1.addNextRoom(room4);
        corridor1.addNextRoom(room7);

        room1.addNextRoom(room2);
        room1.addNextRoom(corridor1);

        room2.addNextRoom(room1);
        room2.addNextRoom(room3);

        room3.addNextRoom(room2);
        room3.addNextRoom(corridor2);

        corridor2.addNextRoom(room3);
        corridor2.addNextRoom(room4);

        room4.addNextRoom(corridor1);
        room4.addNextRoom(corridor2);
        room4.addNextRoom(room7);

        room7.addNextRoom(room4);
        room7.addNextRoom(corridor1);
        room7.addNextRoom(room5);

        room5.addNextRoom(room6);
        room5.addNextRoom(room7);

        //Defining Arts
        ArtObject pMonaLisa = new ArtObject("Mona Lisa", "Leonardo da Vinci", 1503, "Painting");
        ArtObject pStarryNight = new ArtObject("Starry Night", "Vincent van Gogh", 1889, "Painting");
        ArtObject pScream = new ArtObject("The Scream", "Edvard Munch", 1893, "Painting");
        ArtObject sThinker = new ArtObject("The Thinker", "Auguste Rodin", 1902, "Sculpture");
        ArtObject pGuernica = new ArtObject("Guernica", "Pablo Picasso", 1937, "Painting");
        ArtObject sDavid = new ArtObject("David", "Michelangelo", 1504, "Sculpture");
        ArtObject pPersistence = new ArtObject("The Persistence of Memory", "Salvador Dali", 1931, "Painting");
        ArtObject pAngel = new ArtObject("Musician Angel", "Rosso Fiorentino", 1521, "Painting");

        //Defining Guardians
        Human g1 = new Human("Henrik");
        Human g2 = new Human("Hans");


        int visitorCount = random.nextInt(10);
        Vector<Visitor> visitorList = new Vector<>();
        for (int i = 1; i < visitorCount; i++) {
            visitorList.add(new Visitor("Visitor " + i));
        }

        //Adding Rooms
        museum.addRoom(room1);
        museum.addRoom(room2);
        museum.addRoom(room3);
        museum.addRoom(room4);
        museum.addRoom(room5);
        museum.addRoom(room6);
        museum.addRoom(room7);
        museum.addRoom(corridor1);
        museum.addRoom(corridor2);

        //Adding Arts to the rooms
        room1.addArt(pMonaLisa);
        room3.addArt(pStarryNight);
        room4.addArt(sDavid);
        room2.addArt(pGuernica);
        room5.addArt(pScream);
        room1.addArt(sThinker);
        room4.addArt(pPersistence);
        room6.addArt(pAngel);

        //Adding visitors
        for (Visitor visitor : visitorList) {
            museum.addVisitor(visitor);
        }

        //printing Structure and Simulation
        museum.printMuseumName();
        museum.printMuseumStructure();
        museum.startSimu();
    }
}
