package com.sparta.springcore_homework.repository;

import com.sparta.springcore_homework.dto.FoodResponseDto;
import com.sparta.springcore_homework.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByrestaurantId(Long id);
    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String name);

}


