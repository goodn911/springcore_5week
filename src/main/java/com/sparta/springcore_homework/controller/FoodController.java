package com.sparta.springcore_homework.controller;

import com.sparta.springcore_homework.dto.FoodDto;
import com.sparta.springcore_homework.dto.FoodResponseDto;
import com.sparta.springcore_homework.model.Food;
import com.sparta.springcore_homework.repository.RestaurantRepository;
import com.sparta.springcore_homework.service.FoodService;
import com.sparta.springcore_homework.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {


    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){

        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto){
            foodService.creatFood(restaurantId,foodDto);

    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFoods(@PathVariable Long restaurantId){


        return foodService.getFoods(restaurantId);


    }

}
