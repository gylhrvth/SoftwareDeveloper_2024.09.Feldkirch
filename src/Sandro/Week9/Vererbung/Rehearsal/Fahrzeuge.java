package Sandro.Week9.Vererbung.Rehearsal;

public abstract class Fahrzeuge {
     int räder;
     String farbe;


    public Fahrzeuge(int räder, String farbe) {
        this.räder = räder;
        this.farbe = farbe;
    }

    protected abstract void startMotor();

    public void test (){
        System.out.println("test");
    }


}
