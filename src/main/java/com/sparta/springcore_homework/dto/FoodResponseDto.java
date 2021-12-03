package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
//음식 반환할 DTO
public class FoodResponseDto {
    Long id;
    private String name;
    private Long price;
}
