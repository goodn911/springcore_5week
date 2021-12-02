package com.sparta.springcore_homework.repository;

import com.sparta.springcore_homework.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFoodRepository extends JpaRepository<OrderFood,Long> {
}
