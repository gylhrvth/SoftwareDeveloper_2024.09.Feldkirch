package Thiemo.week07.Tv;

import Sandro.Colors;

public class Serie {

    private String title;
    private String genre;
    private int productionYear;
    private String originalLanguage;


    public Serie(String title, String genre, int productionYear, String originalLanguage) {

        this.title = title;
        this.genre = genre;
        this.productionYear = productionYear;
        this.originalLanguage = originalLanguage;

    }

    public String gettitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getgenre() {
        return genre;
    }

    public void setgenre(String genre) {
        this.genre = genre;
    }

    public int getproductionYear() {
        return productionYear;
    }

    public void setproductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getoriginalLanguage() {
        return originalLanguage;
    }

    public void setoriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @Override
    public String toString() {
        return "Serie  {" +
                " Titel = '" + title + '\'' +
                ", Genre = " + genre +
                ", Produktionsjahr = " + String.format("%s%4d cm%s", Colors.COLORS[2], productionYear, Colors.RESET) +
                ", Original Sprache = " + originalLanguage +
                '}';

    }
}
