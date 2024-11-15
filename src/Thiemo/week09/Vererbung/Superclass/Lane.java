package Thiemo.week09.Vererbung.Superclass;

public class Lane  {

    private String position;


    public Lane(String position) {
        this.position = position;
        System.out.println("I am the Lane constructor");
    }

    public String getPosition() {
        return position;
    }
}

