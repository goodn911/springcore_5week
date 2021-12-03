package com.sparta.springcore_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

//음식정보 DTO
public class FoodDto {


    private String name;

    private Long price;
}
