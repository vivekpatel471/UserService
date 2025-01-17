package com.user.service.externals.services;

import com.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable("id") String id);
}
