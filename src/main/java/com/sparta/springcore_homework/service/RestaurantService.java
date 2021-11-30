package com.sparta.springcore_homework.service;

import com.sparta.springcore_homework.dto.RestaurantDto;
import com.sparta.springcore_homework.model.Restaurant;
import com.sparta.springcore_homework.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    //DB에 음식점 저장
    public Restaurant createRestaurant(RestaurantDto restaurantDto) {


        Restaurant restaurant = new Restaurant(restaurantDto);

        restaurantRepository.save(restaurant);

        return restaurant;

    }
    //DB에 저장된 음식점 조회
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }
}
