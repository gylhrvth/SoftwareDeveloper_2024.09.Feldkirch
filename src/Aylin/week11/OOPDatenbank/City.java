package Aylin.week11.OOPDatenbank;

public class City {
    private String name;
    private String province;
    private int population;
    private float longitude;
    private float latitude;

    private Country country;

    public City(String name, String province, int population, float longtitude, float latitude) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = null;
    }

    public void setCountryByCode(Mondial mondial, String code){
        this.country = mondial.getCountryByCode(code);
        if(this.country != null){
            country.addCity(this);
        }
    }
}
