package Aylin.week10.Museum;

import java.util.Vector;

public class Museum {
    private String name;
    private int foundingYear;
    private Vector<Room> roomList;
    private Vector<Human> humanList;

    public Museum(String name, int foundingYear) {
        this.name = name;
        this.foundingYear = foundingYear;
        this.roomList = new Vector<>();
        this.humanList = new Vector<>();
    }

    public void printMuseumName(){
        System.out.println("├── " + name + ", " + foundingYear);
        for (Room room : roomList){
            room.printRoom();
        }
    }

    public void addRoom(Room room){
        if(!roomList.contains(room)){
            roomList.add(room);
        }
    }
}
