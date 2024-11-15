package Aylin.week09.SuperClass;

public class SymphonicConcert extends Concert{
    private String instruments;

    public SymphonicConcert(String name, String date, String location, String genre, String instruments) {
        super(name, date, location, genre);
        this.instruments = instruments;
    }
}
