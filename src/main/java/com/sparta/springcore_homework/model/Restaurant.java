package com.sparta.springcore_homework.model;


import com.sparta.springcore_homework.dto.RestaurantDto;
import com.sparta.springcore_homework.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    //음식점이름
    @Column(nullable = false)
    private String name;
    //최소주문금액
    @Column(nullable = false)
    private Long minOrderPrice;
    //배달요금
    @Column(nullable = false)
    private Long deliveryFee;

    public Restaurant(RestaurantDto restaurantDto) {

        //음식점 유효성검사
        RestaurantValidator.validateRestaurantInput(restaurantDto);

        //음식점 정보
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
