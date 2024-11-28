package Thiemo.week11.OOPdatabank;

public class City {
    private String name;
    private String province;
    private int Population;
    private float Longitude;
    private float latitude;
    private Country country;

    public City(String name, String province, int population, float longitude, float latitude) {

        this.name = name;
        this.province = province;
        this.Population = population;
        this.Longitude = longitude;
        this.latitude = latitude;
        this.country = null;

    }

    public void setCountryByCode(Mondial mondial, String code) {
        country = mondial.getCountryByCode(code);
        if (country != null) {

        }
    }


}
