/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.City;
import entity.Country;
import entityfacade.CountryFacade;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Kristian Nielsen
 */
@Path("country")
public class WorldEndpoint {

    Gson gson = new Gson();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WorldEndpoint
     */
    public WorldEndpoint() {
    }

    /**
     * Retrieves representation of an instance of rest.WorldEndpoint
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/pop/{number}")
    @Produces("application/json")
    public String getCountriesByPop(@PathParam("number") int number){
        Collection<Country> countries = CountryFacade.getByPop(number);
        for(Country c: countries){
            c.setCityCollection(null);
            c.setCountrylanguageCollection(null);
        }
        return gson.toJson(countries);
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public String getAllCountries() {
        
        Collection<Country> countries = CountryFacade.getAllCountries();
        
        for(Country c: countries){
            c.setCityCollection(null);
            c.setCountrylanguageCollection(null);
        }
        
        return gson.toJson(countries);
        //return arr.toString();
    }

    @GET
    @Path("/{country}/cities")
    @Produces("application/json")
    public String getCities(@PathParam("country") String countryName){
        Country c = CountryFacade.getCountryByName(countryName);
        Collection<City> cities = CountryFacade.getCities(c);
        c.setCityCollection(null);
        c.setCountrylanguageCollection(null);
        return gson.toJson(cities);
    }
    
    /**
     * PUT method for updating or creating an instance of WorldEndpoint
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("/city")
    @Consumes("application/json")
    public void createCity(String content) {
        City c = gson.fromJson(content, City.class);
        CountryFacade.createCity(c);
    }
}
