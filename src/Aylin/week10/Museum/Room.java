package Aylin.week10.Museum;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.Random;
import java.util.Vector;

public class Room {
    public static Random random = new Random();

    private String name;
    private Vector<Room> nextRoom;
    private Vector<ArtObject> art;
    private Vector<Visitor> visitors;

    public Room(String name) {
        this.name = name;
        this.nextRoom = new Vector<>();
        this.art = new Vector<>();
        this.visitors = new Vector<>();
    }

    public void addNextRoom(Room next){
        nextRoom.add(next);
        next.nextRoom.add(this);
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

    public boolean hasArt() {
        return !art.isEmpty();
    }

    public void printArt() {
        if (this.getClass().equals(Corridor.class)){

        } else {
            if (art.isEmpty()) {
                System.out.println("│   │   ├── new Arts - coming soon!");
            } else {
                for (ArtObject arts : art) {
                    arts.printArtObject();
                }
            }
        }
    }

    public void dailyTasks(Visitor visitor){
        if(random.nextInt(100) < 1){
            System.out.println(Colors.COLORS[2] + visitor.getName() + " is bored and wants to go home." + Colors.RESET);
        } else {
            if (visitor != null && hasArt()) {
                visitor.observeRandomArt(this);
            }
        }
    }

    public void printVisitors() {
        System.out.println("Currently " + visitors.size() + " visitors in " + name);
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void removeVisitor(Visitor visitor) {
        visitors.remove(visitor);
    }
}