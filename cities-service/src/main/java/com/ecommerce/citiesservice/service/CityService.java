package com.ecommerce.citiesservice.service;

import com.ecommerce.citiesservice.dto.CityDTO;
import com.ecommerce.citiesservice.model.City;
import com.ecommerce.citiesservice.repository.ICityRepository;
import com.ecommerce.citiesservice.repository.IHotelsAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CityService implements ICityService {

    @Autowired
    private IHotelsAPI hotelsAPI;
    
    @Autowired
    private ICityRepository cityRepository;
    

    
    @Override
    @CircuitBreaker(name= "hotels-service", fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name = "hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {

        //buscamos ciudad original
        City city = cityRepository.findCityEntityByNameAndCountry(name, country);

        //creamos el DTO de la ciudad + lista de hoteles
        CityDTO cityDTO = new CityDTO();

        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        //buscamos la lista de hoteles en la API y asignamos
        cityDTO.setHotelList(hotelsAPI.getHotelsByCityId(city.getCity_id()));


        //Test excepcion
      // createException();

        return cityDTO;
    }

  
    public CityDTO fallbackGetCitiesHotel (Throwable throwable) {
        return new CityDTO(999999999L,"Failed", "Failed", "Failed", "Failed", null);
    }

    public void createException () {
        throw new IllegalArgumentException("Test Resilience4J, Circuit Breaker");
    }
    
   
    
    
    

    @Override
    public List<City> findAll() {
      return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id) {
       cityRepository.deleteById(id);
    }

    @Override
    public City update(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findCityEntityByName(name);
    }



}
