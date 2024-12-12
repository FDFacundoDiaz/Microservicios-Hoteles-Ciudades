package com.todocodeacademy.hotelsservice.service;

import com.todocodeacademy.hotelsservice.model.Hotel;
import com.todocodeacademy.hotelsservice.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IHotelService{

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
