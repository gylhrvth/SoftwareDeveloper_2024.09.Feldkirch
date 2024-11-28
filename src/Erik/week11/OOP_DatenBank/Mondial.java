package Erik.week11.OOP_DatenBank;

import java.util.Vector;

public class Mondial {

    // Attribute
    private Vector<Country> countryList;


    // Konstruktor
    public Mondial() {
        countryList = new Vector<>();
    }


    // Methode
    public void addCountry(Country c){
        if (!countryList.contains(c)){
            countryList.add(c);
        }
    }

    public Country getCountryByCode(String code){
        Country result = null;
        for (Country c : countryList){
            if (c.getCode().equals(code)) {
                result = c;
            }
        }
        return result;
    }
}