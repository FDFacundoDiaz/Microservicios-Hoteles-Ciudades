package com.ecommerce.hotels_service.controller;

import com.ecommerce.hotels_service.model.Hotel;
import com.ecommerce.hotels_service.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/hotels")
public class HotelsController {

    @Autowired
    private IHotelService servHotel;

    @GetMapping("/city_id/{city_id}")
    public ResponseEntity <List<Hotel>> getHotelsByCityId (@PathVariable Long city_id) {
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
    public ResponseEntity <Hotel> createHotel (@RequestBody Hotel Hotel) {
        Hotel newHotel = servHotel.save(Hotel);
        return ResponseEntity.ok(newHotel);
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity <Hotel> deleteHotelById(@PathVariable Long id) {
        servHotel.deleteById(id);
        return ResponseEntity.ok().build();
    }

    

}
