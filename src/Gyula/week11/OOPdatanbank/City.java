package Gyula.week11.OOPdatanbank;

public class City {
    private String name;
    private String province;
    private int population;
    private float longitude;
    private float latitude;

    private Country country;

    public City(
        String name,
        String province,
        int population,
        float longitude,
        float latitude
    ){
        this.name = name;
        this.province = province;
        this.population = population;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = null;
    }

    public void setCountryByCode(Mondial mondial, String code){
        country = mondial.getCountryByCode(code);
        if (country != null){
            country.addCity(this);
        }
    }

}


