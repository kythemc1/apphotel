package com.example.hotel.service;


import com.example.hotel.dto.OrderDto;
import com.example.hotel.dto.RequestDto;
import com.example.hotel.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Long create(RequestDto requestDto);

    boolean update(OrderDto orderDto);

    Optional<OrderEntity> getById(Long id);

    void delete(Long Id);

    List<OrderEntity> getAll(String name);


    List<OrderEntity> getAll();
}
