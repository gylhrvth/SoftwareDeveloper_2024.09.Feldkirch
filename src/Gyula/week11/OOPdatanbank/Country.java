package Gyula.week11.OOPdatanbank;

import java.util.Vector;

public class Country {
    private String name;
    private String code;
    private String capital;
    private String province;
    private float area;
    private int population;
    private Vector<City> cityList;

    public Country(
            String name,
            String code,
            String capital,
            String province,
            float area,
            int population
    ){
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.province = province;
        this.area = area;
        this.population = population;

        this.cityList = new Vector<>();
    }

    public String getCode() {
        return code;
    }

    public void addCity(City city){
        if (!cityList.contains(city)){
            cityList.add(city);
        }
    }
}
