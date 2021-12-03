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
//반환될 음식 주문서 DTO
public class OrderResponseDto {
    private String restaurantName;
    private List<OrderFoodResponseDto> foods ;
    private Long deliveryFee;
    private Long totalPrice;

}
