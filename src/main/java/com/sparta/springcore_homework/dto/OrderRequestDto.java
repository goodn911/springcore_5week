package com.sparta.springcore_homework.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

//주문내역서 Dto
public class OrderRequestDto {


    private Long restaurantId;
    private List<OrderFoodRequestDto> foods;


}
