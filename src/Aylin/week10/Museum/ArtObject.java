package Aylin.week10.Museum;

public class ArtObject {
    private String name;
    private String artist;
    private int year;
    private String type;

    public ArtObject(String name, String artist, int year, String type) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.type = type;
    }

    public void printArtObject(){
        System.out.println("│   │   ├── " + name + ", " + artist + " (" + year + ")");
    }
}
