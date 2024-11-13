package Akif_Malik.ZOO;

public class ZooMAIN {
    public static void main(String[] args) {

        Zoo tiergartenDornbirn = new Zoo("Tiergarten Dornbirn", 2022);

        Gehege alpenwiese = new Gehege("Alpenwiese");
        Gehege ried = new Gehege("Ried");
        Gehege terrarium = new Gehege("Terrarium (warm)");

        alpenwiese.addTier(new Tiere("Rijska", "Kuh"));
        ried.addTier(new Tiere("Garmond", "Storch"));
        ried.addTier(new Tiere("Hugo", "Storch"));
        ried.addTier(new Tiere("Idaxis", "Storch"));

        tiergartenDornbirn.addGehege(alpenwiese);
        tiergartenDornbirn.addGehege(ried);
        tiergartenDornbirn.addGehege(terrarium);

        tiergartenDornbirn.printStructure();
    }
}
