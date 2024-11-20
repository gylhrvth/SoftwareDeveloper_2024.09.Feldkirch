package Erik.week10.Influencer;

public class InfluencerStart {
    public static void main(String[] args) {

        // Objekt erstellen
        Influencer influencerRezo = new Influencer("Rezo", 32, "Musik, Unterhaltung");
        System.out.println("Test: " + influencerRezo);


        // Methoden aufrufen

    }
}

/*
 Wegen abstracter klasse kann kein neues object von der klasse erstellt werden
        Channel rezoJaLolEy = new Channel("Youtube", 1640000);
        Channel renzo = new Channel("Youtube", 1210000);
        Channel schlumpf = new Channel("Youtube", 549000);


        influencerRezo.addChannel(rezoJaLolEy);     // Abo 1.640.000
        influencerRezo.addChannel(renzo);           // Abo 1.210.000
        influencerRezo.addChannel(schlumpf);        // Abo   549.000
 */