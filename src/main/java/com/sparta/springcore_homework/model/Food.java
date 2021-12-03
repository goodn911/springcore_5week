package com.sparta.springcore_homework.model;

import com.sparta.springcore_homework.dto.FoodDto;

import com.sparta.springcore_homework.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    //음식점 id
    @Column(nullable = false)
    private Long restaurantId;
    //음식이름
    @Column(nullable = false)
    private String name;
    //음식가격
    @Column(nullable = false)
    private Long price;




    public Food(Long restaurantId,FoodDto foodDto) {

        //음식유효성검사
        FoodValidator.validateFoodInput(foodDto);

        this.restaurantId = restaurantId;
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }


}
