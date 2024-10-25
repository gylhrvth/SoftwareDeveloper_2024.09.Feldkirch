package Furkan.week07.Serie;

public class AnimeSerie {
    private String title;
    private String genre;
    private int year;
    private String language;

    public AnimeSerie(String title, String genre, int year, String language){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.language = language;
    }

    public void printOut(){
        System.out.println("Titel: " + title + " Genre: " + genre + "Ausstrahlungsjahr: " + year + " Originalsprache: " + language);

    }

    public String toString(){
        return "Titel: " + title + " Genre: " + genre + "Ausstrahlungsjahr: " + year + " Originalsprache: " + language;

    }
}
