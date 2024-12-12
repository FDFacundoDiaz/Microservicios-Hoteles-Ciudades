package com.ecommerce.citiesservice.service;

import com.ecommerce.citiesservice.dto.CityDTO;
import com.ecommerce.citiesservice.model.City;
import java.util.List;

public interface ICityService {

    public List<City> findAll();
    public City findById(Long id);
    public City save (City city);
    public void deleteById (Long id);
    public City update (City city);
    
    public City findCityByName (String name);
    
    public CityDTO getCitiesHotels(String name, String country);
    
}
