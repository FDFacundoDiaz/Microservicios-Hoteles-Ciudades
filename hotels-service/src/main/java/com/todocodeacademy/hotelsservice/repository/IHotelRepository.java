package com.todocodeacademy.hotelsservice.repository;


import com.todocodeacademy.hotelsservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT p FROM Hotel p WHERE p.city_id=:city_id")
    List<Hotel> findHotelEntityByCity_id (Long city_id);

}
