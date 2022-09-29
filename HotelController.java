package com.example.hotel.controller;

import com.example.hotel.dto.OrderDto;
import com.example.hotel.dto.RequestDto;
import com.example.hotel.entity.OrderEntity;
import com.example.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/hotel"))
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }

    @PostMapping("/vtc")
    public Long create(@RequestBody RequestDto requestDto){
        return hotelService.create(requestDto);
    }

    @PutMapping("/update")
    public  Boolean update(@RequestBody OrderDto orderDto){
        return hotelService.update(orderDto);
    }

    @GetMapping("/getbyid/{id}")
    public Optional<OrderEntity> getById(@PathVariable("id") Long id){
       return hotelService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        hotelService.delete(id);
    }

    @GetMapping("/getAll")
    public List<OrderEntity> getAll()
    {
        return hotelService.getAll();
    }
}
