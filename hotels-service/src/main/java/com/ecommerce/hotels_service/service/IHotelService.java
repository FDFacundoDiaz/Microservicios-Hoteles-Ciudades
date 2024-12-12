package com.ecommerce.hotels_service.service;


import com.ecommerce.hotels_service.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId (Long city_id);

    public List<Hotel> findAll();
    Optional<Hotel> findById(Long id);
    public Hotel save (Hotel hotel);
    public void deleteById (Long id);
    public Hotel update (Hotel hotel);

    
}
