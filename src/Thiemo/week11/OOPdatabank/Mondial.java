package Thiemo.week11.OOPdatabank;

import java.util.Vector;

public class Mondial {

    private Vector<Country> countrylist;


    public Mondial(){
        countrylist = new Vector<>();
    }


    public void addCountry(Country country){
        if (!countrylist.contains(country)){
            countrylist.add(country);
        }
    }
    public Country getCountryByCode(String code){
        Country result = null;
        for (Country c : countrylist){
            if (c.getCode().equals(code)){
                result = c;
            }
        }
        return result;
    }
}