package Aylin.week09.SuperClass;

public class Theater extends Event {
    private String cast;
    private String writer;

    public Theater(String name, String date, String location, String writer){
        super(name, date, location);
        this.writer = writer;
        System.out.println("I am the Theater Constructor.");
    }

    public void sketch(){

    }

    public void applause(){

    }
}
