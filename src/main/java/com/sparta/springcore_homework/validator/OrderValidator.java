package com.sparta.springcore_homework.validator;


import com.sparta.springcore_homework.model.Restaurant;

public class OrderValidator {

    public static long validateOrderInput(Restaurant restaurant, Long price){
        if(price<restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("주문금액이 최소주문금액보다 작습니다.");
        }
        return price+ restaurant.getDeliveryFee();
    }
}
