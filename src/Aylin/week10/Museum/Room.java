package Aylin.week10.Museum;

import java.util.Vector;

public class Room {
    private String name;
    private Vector<Room> nextRoom;
    private Vector<ArtObject> art;

    public Room(String name) {
        this.name = name;
        this.nextRoom = new Vector<>();
        this.art = new Vector<>();
    }

    public void printRoom(){
        System.out.println("│   ├── " + name);
        printArt();
    }

    public void addArt(ArtObject artObject){
        this.art.add(artObject);
    }

    public Vector<ArtObject> getArt() {
        return art;
    }

    public void printArt() {
        if (this.getClass().equals(Corridor.class)){
        }else{
            if (art.isEmpty()) {

                System.out.println("│   │   ├── new Arts - coming soon!");
            } else {
                for (ArtObject arts : art) {
                    arts.printArtObject();
                }
            }
        }
    }
}
