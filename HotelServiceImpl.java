package com.example.hotel.service.impl;

import com.example.hotel.dto.RequestDto;
import com.example.hotel.entity.*;
import com.example.hotel.repository.CustomerEntityRepository;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.repository.OrderRepository;
import com.example.hotel.dto.OrderDto;
import com.example.hotel.repository.RateRepository;
import com.example.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final OrderRepository orderRepository;
    private final CustomerEntityRepository customerEntityRepository;

    private final RateRepository rateRepository;
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(OrderRepository orderRepository, CustomerEntityRepository customerEntityRepository, HotelRepository hotelRepository, RateRepository rateRepository) {
        this.orderRepository = orderRepository;
        this.customerEntityRepository = customerEntityRepository;
        this.hotelRepository = hotelRepository;
        this.rateRepository = rateRepository;
    }

    @Override
    public Long create(RequestDto requestDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(requestDto.getCustomerName());
        customerEntity.setAge(requestDto.getAge());
        customerEntity.setAddress(requestDto.getCustomerAddress());
        customerEntity.setCmnd(requestDto.getCmnd());
//////////////
        HotelEntity hotelEntity =new HotelEntity();
        hotelEntity.setName(requestDto.getHotelName());
        hotelEntity.setAddress(requestDto.getHotelAddress());
//////////////
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName(requestDto.getCustomerName());
        orderEntity.setDays(requestDto.getDays());
        orderEntity.setLunchLevel(requestDto.getLunchLevel());
        orderEntity.setNights(requestDto.getNights());
        orderEntity.setDinnerlevel(requestDto.getDinnerLevel());
        orderEntity.setCost(requestDto.getDinnerLevel()*1000+requestDto.getLunchLevel()*1000+requestDto.getDays()*1000+requestDto.getNights()*1000+" nghin dong");


        orderEntity.setCustomerEntity(customerEntity);
        orderEntity.setHotelEntity(hotelEntity);

        List<OrderEntity> orderEntities = new ArrayList<>();

        orderEntities.add(orderEntity);

        customerEntity.setOrderEntities(orderEntities);
        hotelEntity.setOrderEntities(orderEntities);

/////////////
        RateEntity rateEntity =new RateEntity();
        rateEntity.setCustomerEntity(customerEntity);
        rateEntity.setFeeBack(requestDto.getFeedBack());
        List<RateEntity> rateEntities =new ArrayList<>();
        rateEntities.add(rateEntity);
        customerEntity.setRateEntities(rateEntities);
/////////////
        HotelServiceEntity hotelServiceEntity=new HotelServiceEntity();
        hotelServiceEntity.setHotelEntity(hotelEntity);
        hotelServiceEntity.setDays(requestDto.getDays());
        hotelServiceEntity.setNights(requestDto.getNights());
        hotelServiceEntity.setLunchlevel(requestDto.getLunchLevel());
        hotelServiceEntity.setDinnerLevel(requestDto.getDinnerLevel());
        List<HotelServiceEntity> hotelServiceEntities=new ArrayList<>();
        hotelServiceEntities.add(hotelServiceEntity);
        hotelEntity.setHotelServiceEntities(hotelServiceEntities);


/////////////
        customerEntity = customerEntityRepository.save(customerEntity);
        hotelEntity=hotelRepository.save(hotelEntity);

        System.out.println("orderEntity.getOrderId()");
        return customerEntity.getCustomerId();

    }

    @Override
    public boolean update(OrderDto orderDto) {
        return false;
    }

    @Override
    public Optional<OrderEntity> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Long Id) {
        orderRepository.deleteById(Id);
    }

    @Override
    public List<OrderEntity> getAll(String name) {
        return null;
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }
}
