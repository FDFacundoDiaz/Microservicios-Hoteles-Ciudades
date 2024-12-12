
package com.ecommerce.citiesservice.repository;

import com.ecommerce.citiesservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository <City, Long> {
    
    
      @Query("SELECT p FROM City p WHERE p.name=:name")
      public City findCityEntityByName (String name);
      
  
      @Query("SELECT p FROM City p WHERE p.name=:name and p.country=:country")
      public City findCityEntityByNameAndCountry (String name, String country);
  
}


