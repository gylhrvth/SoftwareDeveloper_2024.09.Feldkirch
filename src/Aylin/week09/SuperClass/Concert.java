package Aylin.week09.SuperClass;

public class Concert extends Event {
    private String musician;
    private String genre;

    public Concert(String name, String date, String location, String genre){
        super(name, date, location);
        this.genre = genre;
        System.out.println("I am the Concert Constructor.");
    }

    public void songs(){

    }


}
