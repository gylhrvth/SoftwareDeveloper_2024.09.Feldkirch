package Thiemo.week11.OOPdatabank;

import java.util.Vector;

public class Country {

    private String name;
    private String code;
    private String capital;
    private String province;
    private float area;
    private float population;
    private Vector<City> citylist;

    public Country(
            String name, String code, String capital, String province, float area, float population) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.province = province;
        this.area = area;
        this.population = population;
        this.citylist = new Vector<>();
    }

    public String getCode() {
        return code;
    }

    public void addCity(City city) {
        if (!citylist.contains(city)) {
            citylist.add(city);
        }
    }

}