package Erik.week11.OOP_DatenBank;

public class City {

    // Attribute
    private String name;
    private String province;
    private int population;
    private float longtitude;
    private float longitude;

    private Country country;    // Klassen aufruf


    // Konstruktor
    public City(String name, String province, int population, float longtitude, float longitude) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.longtitude = longtitude;
        this.longitude = longitude;
        this.country = null;
    }


    // Methoden
    public void setCountryByCode(Mondial mondial, String code){
        country = mondial.getCountryByCode(code);
        if (country != null){
            country.addCity(this);
        }
    }
}
