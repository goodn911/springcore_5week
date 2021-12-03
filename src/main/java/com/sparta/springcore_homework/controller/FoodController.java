package com.sparta.springcore_homework.controller;

import com.sparta.springcore_homework.dto.FoodDto;
import com.sparta.springcore_homework.dto.FoodResponseDto;
import com.sparta.springcore_homework.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FoodController {


    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {

        this.foodService = foodService;
    }
    //음식점 ID,음식정보 입력
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto) {
        foodService.creatFood(restaurantId, foodDto);

    }
    //메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFoods(@PathVariable Long restaurantId) {


        return foodService.getFoods(restaurantId);


    }

}
