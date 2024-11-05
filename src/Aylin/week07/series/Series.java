package Aylin.week07.series;

import Aylin.week07.human.Human;
import Sandro.Colors;

public class Series {
    private String title;
    private String genre;
    private int year;
    private String origin;
    private int episodes;
    private int seasons;
    private Human director;
    private Human producer;
    private Human writer;
    private boolean errorMsg;

    public Series(String title, String genre, int year, String origin, int seasons, int episodes){
        this.title = Colors.COLORS[4] + title + Colors.RESET;
        this.genre = Colors.COLORS[5] + genre + Colors.RESET;
        this.year = year;
        this.origin = Colors.COLORS[6] + origin + Colors.RESET;;
        this.episodes = episodes;
        this.seasons = seasons;
        this.director = null;
        this.producer = null;
        this.writer = null;
    }

    public boolean hireDirector(Human director){
        if(this.director != null){
            System.out.println("You have already hired a director.");
            return false;
        }
        this.director = director;
        System.out.println(this.director.getFullname() + " is hired as a director.");
        return true;
    }

    public boolean hireProducer(Human producer){
        if(this.producer != null){
            System.out.println("You have already hired a producer.");
            return false;
        }
        this.producer = producer;
        System.out.println(this.producer.getFullname() + " is hired as a producer.");
        return true;
    }

    public boolean hireWriter(Human writer){
        if(this.writer != null){
            System.out.println("You have already hired a writer.");
            return false;
        }
        this.writer = writer;
        System.out.println(this.writer.getFullname() + " is hired as a writer.");
        return true;
    }

    public void fireDirector(){
        if(this.director  != null){
            System.out.println("You fired " + this.director.getFullname() + ", your director, because he was breathing.");
            this.director = null;
        }else{
            System.out.println("You can't fire a director if you don't have one.");
        }
    }

    public void fireProducer(){
        if(this.producer != null){
            System.out.println("You fired the producer.");
            this.producer = null;
        }else{
            System.out.println("You can't fire a producer if you don't have one.");
        }
    }

    public void fireWriter(){
        if(this.writer != null){
            System.out.println("You fired the writer.");
            this.writer = null;
        }else{
            System.out.println("You can't fire a writer if you don't have one.");
        }
    }

    public void deadWriter(){
        if(this.writer != null){
            System.out.printf("Your writer %s died. \n", writer.getFullname());
            this.writer = null;
        }else{
            System.out.println("You need a writer to continue the production.");
        }
    }

    public void startProduction(int episodes) {
        if (this.director == null) {
            System.out.println(Colors.COLORS[1] + "You need to hire a Director to start the project." + Colors.RESET);
        }else if (this.producer == null) {
            System.out.println(Colors.COLORS[1] + "You need to hire a Producer to start the project." + Colors.RESET);
        }else if (this.writer == null) {
            System.out.println(Colors.COLORS[1] + "You need to hire a Writer to start the project." + Colors.RESET);
        }else {
            System.out.println("...Production of Ep " + episodes + ".");
        }
    }

    @Override
    public String toString() {
        String dirName = "No director";
        String prodName = "No producer";
        String writerName = "No writer";

        if(this.director != null) {
            dirName = Colors.COLORS[4] + this.director.getFullname() + Colors.RESET;
        }
        if(this.producer != null) {
            prodName = Colors.COLORS[6] + this.producer.getFullname() + Colors.RESET;
        }
        if(this.writer != null) {
            writerName = Colors.COLORS[5] + this.writer.getFullname() + Colors.RESET;
        }
        return "Series: " + title + "\nGenre: " + genre + "\nPremiered in: " + year + "\nOrigin: "+
                origin + "\nSeasons: " + seasons + "\nEpispdes: " + episodes + "\nDirector: " + dirName +
                "\nProducer: " + prodName + "\nWriter: " + writerName;
    }
}
