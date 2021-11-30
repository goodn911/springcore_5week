package com.sparta.springcore_homework.model;

import com.sparta.springcore_homework.dto.FoodDto;
import com.sparta.springcore_homework.dto.FoodResponseDto;
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

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    public Food(Long restaurantId,FoodDto foodDto) {




        if(foodDto.getPrice()<100||foodDto.getPrice()>1000000){
            throw new IllegalArgumentException("가격의 허용범위는 100~1,000,000원 입니다.");
        }
        if(!(foodDto.getPrice()%100==0)){
            throw new IllegalArgumentException("가격은 100원 단위로 입력해야 합니다.");
        }

        this.restaurantId = restaurantId;
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }


}
