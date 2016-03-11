/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityfacade;

import entity.City;
import entity.Country;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class CountryFacade {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamPrepRestAPIPU");
    private static EntityManager em = emf.createEntityManager();
    
    
    public static Collection<Country> getAllCountries(){
        return em.createNamedQuery("Country.findAll").getResultList();
    }
    
    public static Country getCountryByName(String name){
        return (Country) em.createNamedQuery("Country.findByName").setParameter("name", name).getSingleResult();
    }
    
    public static Collection<Country> getByPop(int population){
        return em.createNamedQuery("Country.findByPopulation").setParameter("population", population).getResultList();
    }
    
    public static Collection<City> getCities(Country c){
        return em.createNamedQuery("City.findByCountry").setParameter("country", c).getResultList();
    }
    
    public static void createCity(City c){
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public static City getCityByName(String name){
        return (City) em.createNamedQuery("City.findByName").setParameter("name", name).getSingleResult();
    }
    
    
}
