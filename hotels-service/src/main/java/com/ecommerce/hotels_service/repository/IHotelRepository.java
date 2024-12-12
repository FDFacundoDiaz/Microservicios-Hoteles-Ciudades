
package com.ecommerce.hotels_service.repository;

import com.ecommerce.hotels_service.model.Hotel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRepository extends JpaRepository <Hotel, Long> {
    
    @Query("SELECT p FROM Hotel p WHERE p.city_id=:city_id")
    List<Hotel> findHotelEntityByCity_id (Long city_id);
    
    
}
