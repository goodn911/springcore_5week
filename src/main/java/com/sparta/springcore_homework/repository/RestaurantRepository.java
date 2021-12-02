package com.sparta.springcore_homework.repository;

import com.sparta.springcore_homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {


}
