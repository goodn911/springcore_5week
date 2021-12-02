package com.sparta.springcore_homework.controller;


import com.sparta.springcore_homework.dto.OrderFoodRequestDto;
import com.sparta.springcore_homework.dto.OrderRequestDto;
import com.sparta.springcore_homework.dto.OrderResponseDto;
import com.sparta.springcore_homework.repository.OrderEntityRepository;
import com.sparta.springcore_homework.repository.OrderFoodRepository;
import com.sparta.springcore_homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

   private final OrderService orderService;

   @Autowired
    public OrderController(OrderService orderService){
       this.orderService=orderService;
   }

   @PutMapping("/order/request")
    public List<OrderResponseDto> createOrder (@RequestBody OrderRequestDto orderRequestDto){
       List<OrderResponseDto> orderResponseDtos= OrderService.createOrder(orderRequestDto);
       return orderResponseDtos;
   }



}
