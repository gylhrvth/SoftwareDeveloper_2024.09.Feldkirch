package Sandro.Week9.Vererbung.Rehearsal;

public class Auto extends Fahrzeuge{
    private int tür;


    public Auto(int räder, String farbe, int tür) {
        super(räder, farbe);
        this.tür = tür;
    }


    public void startMotor(){
        System.out.println("Start Auto");
    }

}
