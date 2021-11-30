package com.sparta.springcore_homework.validator;

import com.sparta.springcore_homework.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void validateRestaurantInput(RestaurantDto restaurantDto){

        if(restaurantDto.getMinOrderPrice()<1000||restaurantDto.getMinOrderPrice() > 100000){
            throw new IllegalArgumentException("주문금액 허용값은 1,000~100,000원 입니다.");
        }
        if(!(restaurantDto.getMinOrderPrice()%100 == 0)){
            throw new IllegalArgumentException("주문금액 100원단위로 입력가능합니다.");

        }
        if(restaurantDto.getDeliveryFee()<0||restaurantDto.getDeliveryFee()>10000){
            throw new IllegalArgumentException("배달비 허용값은 0~10,000원 입니다.");
        }
        if(!(restaurantDto.getDeliveryFee()%500==0)){
            throw new IllegalArgumentException("배달비 500원 단위로 입력가능합니다.");
        }

    }
}
