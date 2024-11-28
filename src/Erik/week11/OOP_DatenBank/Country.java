package Erik.week11.OOP_DatenBank;

import java.util.Vector;

public class Country {

    // Attribute
    private String name;
    private String code;
    private String capital;
    private String province;
    private float area;
    private int population;
    private Vector<City> cityList;


    // Konstruktor
    public Country(String name, String code, String capital, String province, float area, int population) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.province = province;
        this.area = area;
        this.population = population;
        this.cityList = new Vector<>();
    }


    // Getter - Setter
    public String getCode() {
        return code;
    }


    // Methoden
    public void addCity(City city){
        if (!cityList.contains(city)){
            cityList.add(city);
        }
    }


}