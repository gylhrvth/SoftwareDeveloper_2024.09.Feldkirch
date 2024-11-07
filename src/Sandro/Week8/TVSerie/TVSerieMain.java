package Sandro.Week8.TVSerie;

public class TVSerieMain {
    public static void main(String[] args) {

        TVSchauspieler sandro = new TVSchauspieler("Sandro", "Boso", 27,9, 37);
        TVSchauspieler johanna = new TVSchauspieler("Johanna", "Banana",21,3,15);
        TVSchauspieler django = new TVSchauspieler("Django","Mango",54,18,512);
        TVRegisseur tarantino = new TVRegisseur("Quentin", "Tarantino", 57, 10,900);

        TVSerie twinPeaks = new TVSerie("Twin Peaks", "SciFi", 2009);

        //generiert schauspieler list
        //scouting list


        System.out.println(twinPeaks);

        twinPeaks.addScouting(sandro);
        twinPeaks.addScouting(johanna);
        twinPeaks.addScouting(django);
        System.out.println("Scounting Liste: "+twinPeaks.getScoutingListe());

        twinPeaks.startProduction();
        twinPeaks.hireRegisseur(tarantino);
        twinPeaks.startProduction();
        twinPeaks.addSchauspieler(sandro);
        twinPeaks.addSchauspieler(johanna);
        System.out.println("Scounting Liste: "+twinPeaks.getScoutingListe());
        twinPeaks.startProduction();

        System.out.println(twinPeaks);


    }
}
