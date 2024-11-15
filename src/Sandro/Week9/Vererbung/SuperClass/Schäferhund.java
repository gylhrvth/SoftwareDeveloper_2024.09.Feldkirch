package Sandro.Week9.Vererbung.SuperClass;

public class Schäferhund extends Hund {
    private String spizteOhren;

    public Schäferhund(String name, int age, String genus, String fellFarbe, boolean beißt, String spizteOhren) {
        super(name, age, genus, fellFarbe, beißt);
        this.spizteOhren = spizteOhren;
        System.out.println("Ich bin der Schäferhund Konstruktor");
    }

    public void hüttetSchafe(){
        System.out.println("määäähh");
    }
}
