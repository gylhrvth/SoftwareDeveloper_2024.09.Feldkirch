package Aylin.week10.Museum;

public class Showroom extends Room {

    public Showroom(String name) {
        super(name);
    }

    @Override
    public void addArt(ArtObject artObject) {
        getArt().add(artObject);
    }
}
