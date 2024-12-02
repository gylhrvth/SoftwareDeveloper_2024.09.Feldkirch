package Aylin.week11.OOPDatenbank;

import java.util.Vector;

public class Mondial {

    private Vector<Country> countryList;

    public Mondial() {
        this.countryList = new Vector<>();
    }

    public void addCountry(Country country){
        if(!countryList.contains(country)){
            countryList.add(country);
        }
    }

    public Country getCountryByCode(String code){
        Country result = null;
        for(Country c : countryList){
            if(c.getCode().equals(code)){
                result = c;
            }
        }
        return result;
    }
}
