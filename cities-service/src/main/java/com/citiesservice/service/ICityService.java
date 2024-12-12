package com.citiesservice.service;

import com.citiesservice.dto.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String country);
}
