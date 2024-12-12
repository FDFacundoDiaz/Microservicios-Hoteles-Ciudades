package com.citiesservice.controller;

import com.citiesservice.dto.CityDTO;
import com.citiesservice.model.City;
import com.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {


    @Autowired
    private ICityService servCity;

    @GetMapping("/hotels")
    public ResponseEntity<CityDTO> getCityAndHotels(@RequestParam String name,
                                                    @RequestParam String country) {
        CityDTO city = servCity.getCitiesHotels(name, country);
        return ResponseEntity.ok(city);
    }


    @GetMapping
    public ResponseEntity <List<City>> getAllCities(){
        List<City> cities = servCity.findAll();
        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cities);
    }


    @GetMapping("/byName")
    public ResponseEntity <City> findCityByName (@RequestParam String name) {
        City city = servCity.findCityByName(name);
        if(city == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }


    @GetMapping ("/{id}")
    public ResponseEntity <City> getCityById(@PathVariable Long id) {
        City city = servCity.findById(id);
        if(city == null) {
            return ResponseEntity.notFound().build();
        }
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
