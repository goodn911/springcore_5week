package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
//주문내역서에 있는 food List dto
public class OrderFoodRequestDto {

    private Long id;
    private Long quantity;
}
