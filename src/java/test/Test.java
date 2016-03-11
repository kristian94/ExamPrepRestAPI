/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.City;
import entity.Country;
import entityfacade.CountryFacade;
import java.util.Collection;
import java.util.List;
import rest.WorldEndpoint;

/**
 *
 * @author Kristian Nielsen
 */
public class Test {
    
    
    public static void main(String[] args) {
        Collection<Country> countries = CountryFacade.getByPop(300_000_000);
        Country country = CountryFacade.getCountryByName("China");
        
        
        System.out.println(CountryFacade.getCityByName("TestTown").getPopulation());
        
        WorldEndpoint we = new WorldEndpoint();
        System.out.println(we.getAllCountries());
    }
}
