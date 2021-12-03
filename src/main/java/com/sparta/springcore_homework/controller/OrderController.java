package com.sparta.springcore_homework.controller;


import com.sparta.springcore_homework.dto.OrderRequestDto;
import com.sparta.springcore_homework.dto.OrderResponseDto;
import com.sparta.springcore_homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

   private final OrderService orderService;

   @Autowired
    public OrderController(OrderService orderService){
       this.orderService=orderService;
   }
    //주문요청 시 음식점정보,음식정보 입력받음
   @PostMapping("/order/request")
    public OrderResponseDto createOrder (@RequestBody OrderRequestDto orderRequestDto){

       return  orderService.createOrder(orderRequestDto);
   }
   //주문조회
    @GetMapping("/orders")
    public List<OrderResponseDto> getOrder(){
        return orderService.getOrder();
    }



}
