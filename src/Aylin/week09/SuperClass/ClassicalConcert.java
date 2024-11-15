package Aylin.week09.SuperClass;

public class ClassicalConcert extends Concert{
    private String conductor;


    public ClassicalConcert(String name, String date, String location, String genre, String conductor) {
        super(name, date, location, genre);
        this.conductor = conductor;
    }
}
