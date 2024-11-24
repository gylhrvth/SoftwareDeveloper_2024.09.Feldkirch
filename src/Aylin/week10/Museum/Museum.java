package Aylin.week10.Museum;

import Sandro.Colors;

import java.util.Random;
import java.util.Vector;

public class Museum {
    public static Random random = new Random();

    private String name;
    private int foundingYear;
    private Vector<Room> roomList;
    private Vector<Visitor> visitorList;

    public Museum(String name, int foundingYear) {
        this.name = name;
        this.foundingYear = foundingYear;
        this.roomList = new Vector<>();
        this.visitorList = new Vector<>();
    }

    public void addVisitor(Visitor visitor){
        if(!visitorList.contains(visitor)){
            visitorList.add(visitor);
        }
    }

    public void printMuseumName() {
        System.out.println("├── " + name + ", " + foundingYear);
        for (Room room : roomList) {
            room.printRoom();
        }
    }

    public void addRoom(Room room) {
        if (!roomList.contains(room)) {
            roomList.add(room);
        }
    }

    public void printMuseumStructure() {
        System.out.println();
        System.out.println(Colors.COLORS[5] + "―――――――――――――――――――――――――――――――――――――――\n" +
                "│            │            │            │            │          │\n" +
                "│            =   Room 3   =   Room 2   =   Room 1   │          │\n" +
                "│            │――――――――――――――――――||――――│          │\n" +
                "│            │        │                             │          │\n" +
                "│ Corridor 2 │        =     Corridor 1              = ENTRANCE <-\n" +
                "│            │ Room 4 │――| |――――――――――――――│          │\n" +
                "│            =        = Room 7  =  Room 5  = Room 6 │          │\n" +
                "│            │        │         │          │        │          │\n" +
                "―――――――――――――――――――――――――――――――――――――――\n" + Colors.RESET);
    }

    public void startSimu() {
        for (int day = 1; day <= 10; day++) {
            System.out.println(Colors.COLORS[6] + "|- Day " + day + " in the Museum -|" + Colors.RESET);
            for (Visitor visitor : visitorList) {
                Room chosenRoom = roomList.get(random.nextInt(roomList.size()));
                visitor.visitRoom(chosenRoom);
                visitor.performDailyTask();
            }
        }
    }
}