package com.sparta.springcore_homework.repository;

import com.sparta.springcore_homework.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
}
