package com.sparta.springcore_homework.validator;


import com.sparta.springcore_homework.model.Restaurant;

public class OrderValidator {
    //음식 총 가격 유효성 검사
    public static long validateOrderInput(Restaurant restaurant, Long price){
        if(price<restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("주문금액이 최소주문금액보다 작습니다.");
        }
        return price+ restaurant.getDeliveryFee();
    }

    //수량유효성검사
    public static void validateQuantityInput(Long quantity) {
        if (quantity < 1 || quantity > 100) {
            throw new IllegalArgumentException("주문수량 허용 범위는 1~100개 사이입니다.");
        }
    }
}
