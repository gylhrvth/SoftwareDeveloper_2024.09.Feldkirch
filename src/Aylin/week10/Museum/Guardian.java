package Aylin.week10.Museum;

public class Guardian extends Human{
    private Room currentRoom;

    public Guardian(String name, Room currentRoom) {
        super(name);
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

}
