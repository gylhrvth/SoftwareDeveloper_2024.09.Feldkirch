package Sandro.Week8.TVSerie;

public class TVRegisseur {

    private String firstName;
    private String surName;
    private int age;
    private int movies;

    private int payCheck;


    public TVRegisseur(String firstName, String surName, int age, int movies, int payCheck) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.movies = movies;
        this.payCheck = payCheck;
    }

    public int getPayCheck() {
        return payCheck;
    }

    @Override
    public String toString(){
        return firstName + " " +surName;
    }
}