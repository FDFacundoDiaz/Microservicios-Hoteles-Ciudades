package com.ecommerce.citiesservice.controller;

import com.ecommerce.citiesservice.dto.CityDTO;
import com.ecommerce.citiesservice.model.City;
import com.ecommerce.citiesservice.service.ICityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICityService servCity;

    @GetMapping("/hotels")
    public ResponseEntity <CityDTO> getCityAndHotels(@RequestParam String name,
                                                     @RequestParam String country) {
        CityDTO city = servCity.getCitiesHotels(name, country);
        return ResponseEntity.ok(city);
    }
    
    
    @GetMapping
    public ResponseEntity <List<City>> getAllCities(){
        List<City> cities = servCity.findAll();
        return ResponseEntity.ok(cities);
    }
    
 
     @GetMapping("/byName")
    public ResponseEntity <City> findCityByName (@RequestParam String name) {
        City city = servCity.findCityByName(name);
        return ResponseEntity.ok(city);
    } 
    
    
    @GetMapping ("/{id}")
    public ResponseEntity <City> getCityById(@PathVariable Long id) {
      City city = servCity.findById(id);
       return ResponseEntity.ok(city);
    }
    
    @PostMapping 
    public ResponseEntity <City> createCity (@RequestBody City city) {
        City newCity = servCity.save(city);
        return ResponseEntity.ok(newCity);
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity <City> deleteCityById(@PathVariable Long id) {
        servCity.deleteById(id);
        return ResponseEntity.ok().build();
    }

        

    
    
    
}
