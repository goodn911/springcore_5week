package com.sparta.springcore_homework.service;

import com.sparta.springcore_homework.dto.OrderRequestDto;
import com.sparta.springcore_homework.dto.OrderResponseDto;
import com.sparta.springcore_homework.repository.OrderEntityRepository;
import com.sparta.springcore_homework.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderFoodRepository orderFoodRepository;
    private final OrderEntityRepository orderEntityRepository;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityRepository, OrderFoodRepository orderFoodRepository) {
        this.orderEntityRepository = orderEntityRepository;
        this.orderFoodRepository = orderFoodRepository;
    }

    public List<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto) {

    }
}
