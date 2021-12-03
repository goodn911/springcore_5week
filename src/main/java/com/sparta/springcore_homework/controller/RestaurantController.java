package com.sparta.springcore_homework.controller;

import com.sparta.springcore_homework.dto.RestaurantDto;
import com.sparta.springcore_homework.model.Restaurant;
import com.sparta.springcore_homework.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    //음식점 정보등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant (@RequestBody RestaurantDto restaurantDto){

        Restaurant restaurant = restaurantService.createRestaurant(restaurantDto);
        return restaurant;
    }

    //음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){

       return restaurantService.getRestaurants();
    }



}
