package Aylin.week10.Museum;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum("Louvre", 1793);

        Showroom room1 = new Showroom("Room 1");
        Showroom room2 = new Showroom("Room 2");
        Showroom room3 = new Showroom("Room 3");
        Showroom room4 = new Showroom("Room 4");
        Showroom room5 = new Showroom("Room 5");
        Showroom room6 = new Showroom("Room 6");
        Showroom room7 = new Showroom ("Room 7");
        Corridor corridor1 = new Corridor("Corridor 1");
        Corridor corridor2 = new Corridor("Corridor 2");


        ArtObject pMonaLisa = new ArtObject("Mona Lisa", "Leonardo da Vinci", 1503, "Painting");
        ArtObject pStarryNight = new ArtObject("Starry Night", "Vincent van Gogh", 1889, "Painting");
        ArtObject pScream = new ArtObject("The Scream", "Edvard Munch", 1893, "Painting");
        ArtObject sThinker = new ArtObject("The Thinker", "Auguste Rodin", 1902, "Sculpture");
        ArtObject pGuernica = new ArtObject("Guernica", "Pablo Picasso", 1937, "Painting");
        ArtObject sDavid = new ArtObject("David", "Michelangelo", 1504, "Sculpture");
        ArtObject pPersistence = new ArtObject("The Persistence of Memory", "Salvador Dali", 1931, "Painting");
        ArtObject pAngel = new ArtObject("Musician Angel", "Rosso Fiorentino", 1521, "Painting");


        museum.addRoom(room1);
        museum.addRoom(room2);
        museum.addRoom(room3);
        museum.addRoom(room4);
        museum.addRoom(room5);
        museum.addRoom(room6);
        museum.addRoom(room7);
        museum.addRoom(corridor1);
        museum.addRoom(corridor2);

        room1.addArt(pMonaLisa);
        room3.addArt(pStarryNight);
        room4.addArt(sDavid);
        room2.addArt(pGuernica);
        room5.addArt(pScream);
        room1.addArt(sThinker);
        room4.addArt(pPersistence);
        room6.addArt(pAngel);

        museum.printMuseumName();
    }
}
