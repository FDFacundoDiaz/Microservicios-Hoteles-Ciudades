package com.ecommerce.hotels_service.service;

import com.ecommerce.hotels_service.model.Hotel;
import com.ecommerce.hotels_service.repository.IHotelRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class HotelService implements IHotelService  {

    @Autowired
    private IHotelRepository hotelRepository;        
    
   
    
    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {
      return hotelRepository.findHotelEntityByCity_id(city_id);
    }   
   
    @Override
    public List<Hotel> findAll() {
       return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return (Hotel) hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(Long id) {
       hotelRepository.deleteById(id);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return (Hotel) hotelRepository.save(hotel);
    }
}
