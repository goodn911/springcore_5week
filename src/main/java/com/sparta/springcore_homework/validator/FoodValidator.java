package com.sparta.springcore_homework.validator;


import com.sparta.springcore_homework.dto.FoodDto;


public class FoodValidator {
    //음식 총 가격 유효성 검사
    public static void validateFoodInput(FoodDto foodDto) {

        if (foodDto.getPrice() < 100 || foodDto.getPrice() > 1000000) {
            throw new IllegalArgumentException("가격의 허용범위는 100~1,000,000원 입니다.");
        }
        if (!(foodDto.getPrice() % 100 == 0)) {
            throw new IllegalArgumentException("가격은 100원 단위로 입력해야 합니다.");
        }
    }
}
