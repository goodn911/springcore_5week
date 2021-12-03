package com.sparta.springcore_homework.model;


import com.sparta.springcore_homework.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;



@Entity
@NoArgsConstructor
@Getter
@Setter

//주문내역
public class OrderFood {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    //음식
    @OneToOne
    @JoinColumn(name="food_Id",nullable = false)
    private Food food;
    //주문수량
    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long price;   //수량*1개음식 한가격

    public OrderFood(Food food, Long quantity, Long price) {
       //음식수량 유효성검사
        OrderValidator.validateQuantityInput(quantity);

        this.food = food;
        this.quantity=quantity;
        this.price=price;
    }
}
