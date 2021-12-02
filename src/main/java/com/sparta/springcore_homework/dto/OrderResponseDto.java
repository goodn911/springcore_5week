package com.sparta.springcore_homework.dto;

import java.util.List;

public class OrderResponseDto {
    private String restaurantName;
    private List<OrderFoodResponseDto> foods ;
    private Long deliveryFee;
    private Long totalPrice;
}
