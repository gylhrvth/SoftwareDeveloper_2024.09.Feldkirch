package Aylin.week10.Museum;

import Gyula.WildColors;
import java.util.Random;
import java.util.Vector;

public class Visitor extends Human{
    public static Random random = new Random();
    private Vector<Room> visitedRooms;

    public Visitor(String name) {
        super(name);
        this.visitedRooms = new Vector<>();
    }


    public void observeRandomArt(Room room){
        if(room != null && room.hasArt()) {
            ArtObject randomArt = room.getArt().get(random.nextInt(room.getArt().size()));
            System.out.println(WildColors.getColorFromHSL(54, 1.0, 0.4) + getName() + WildColors.resetColor() + " observes the " + randomArt.getType() + " " + randomArt.getName() + ".");
        } else {
            System.out.println(getName() + " walks around");
        }
    }

    public void performDailyTask() {
        if (!visitedRooms.isEmpty()) {
            Room chosenRoom = visitedRooms.get(random.nextInt(visitedRooms.size()));
            chosenRoom.dailyTasks(this);
            chosenRoom.printVisitors();
        } else {
            System.out.println(this.getName() + " has not visited any rooms yet.");
        }
    }

    public void visitRoom(Room room) {
        if (!visitedRooms.contains(room)) {
            visitedRooms.add(room);
            room.addVisitor(this);
        }
    }
}