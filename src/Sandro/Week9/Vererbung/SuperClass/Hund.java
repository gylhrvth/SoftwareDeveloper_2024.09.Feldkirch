package Sandro.Week9.Vererbung.SuperClass;

public class Hund extends Tier {
    private String fellFarbe;
    private boolean beißt;


    public Hund(String name, int age, String genus, String fellFarbe, boolean beißt) {
        super(name, age, genus);
        this.fellFarbe = fellFarbe;
        this.beißt = beißt;
        System.out.println("Ich bin der Hund Konstuktor");
    }

    public void bringtStöckchen(){
        System.out.println("bringt stöckchen");
    }

}
