package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//반환할 DTO 에 있는 음식정보 리스트 DTO
public class OrderFoodResponseDto {
    private String name;
    private Long quantity;
    private Long price;


}
