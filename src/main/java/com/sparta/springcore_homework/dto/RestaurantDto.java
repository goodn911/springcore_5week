package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//음식점 DTO
public class RestaurantDto {

    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;


}
