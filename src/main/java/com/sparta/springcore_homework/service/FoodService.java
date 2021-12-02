package com.sparta.springcore_homework.service;

import com.sparta.springcore_homework.dto.FoodDto;
import com.sparta.springcore_homework.dto.FoodResponseDto;
import com.sparta.springcore_homework.model.Food;
import com.sparta.springcore_homework.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository =foodRepository;
    }
    @Transactional
    public void creatFood(Long restaurantId, List<FoodDto> foodDto) {
      //List<Food> foods = new ArrayList<>();테스트코드에 필요없음


        for (int i = 0; i < foodDto.size(); i++) {
            Food food = new Food(restaurantId, foodDto.get(i));


            Optional<Food> found=foodRepository.findByRestaurantIdAndName(restaurantId,food.getName());
            if(found.isPresent()){
                throw new IllegalArgumentException("중복된 음식명이 있습니다.");

            }
       //   foods.add(food);  테스트코드에 필요없음
            foodRepository.save(food);
        }

    }
//
//    List<Food> foodList = new ArrayList<>();
//        for (FoodDto foodDto1:foodDto) {
//        Food food = new Food(restaurantId, foodDto1);
//
//
//        Optional<Food> found=foodRepository.findByRestaurantIdAndName(restaurantId,foodDto1.getName());
//        if(found.isPresent()){
//            throw new IllegalArgumentException("중복된 음식명이 있습니다.");
//
//        }
//        foodList.add(food);
//        foodRepository.save(food);
//    }

    public List<FoodResponseDto> getFoods(Long restaurantId) {
            List<Food> foodList=foodRepository.findByRestaurantId(restaurantId);

            List<FoodResponseDto> foodResponseDtos = new ArrayList<>();

            for(int i = 0 ; i<foodList.size();i++){

               FoodResponseDto foodResponseDto= new FoodResponseDto(foodList.get(i).getId(),foodList.get(i).getName(),foodList.get(i).getPrice());
               foodResponseDtos.add(foodResponseDto);
            }

        return foodResponseDtos;
    }
}
