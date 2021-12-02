package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDto {
    private String restaurantName;
    private List<OrderFoodResponseDto> foods ;
    private Long deliveryFee;
    private Long totalPrice;

}
