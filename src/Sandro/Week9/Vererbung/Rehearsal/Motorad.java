package Sandro.Week9.Vererbung.Rehearsal;

public class Motorad extends Fahrzeuge {
    private String pedal;

    public Motorad(int räder, String farbe, String pedal) {
        super(räder, farbe);
        this.pedal = pedal;
    }


    @Override
    public void startMotor() {
        System.out.println("");
    }
}
