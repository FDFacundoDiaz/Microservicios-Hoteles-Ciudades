package com.todocodeacademy.hotelsservice.controller;

import com.todocodeacademy.hotelsservice.model.Hotel;
import com.todocodeacademy.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelsController {


    @Autowired
    private IHotelService servHotel;

    @GetMapping("/city_id/{city_id}")
    public ResponseEntity<List<Hotel>> getHotelsByCityId (@PathVariable Long city_id) {
        List<Hotel> hotelsByCityId = servHotel.getHotelsByCityId(city_id);
        return ResponseEntity.ok(hotelsByCityId);
    }

    @GetMapping
    public ResponseEntity <List<Hotel>> getAllHotels(){
        List<Hotel> hotels = servHotel.findAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Hotel> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = servHotel.findById(id);
        return hotel.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity <Hotel> createHotel (@RequestBody Hotel hotel) {
        Hotel newHotel = servHotel.save(hotel);
        return ResponseEntity.ok(newHotel);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Hotel> deleteHotelById(@PathVariable Long id) {
        servHotel.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
