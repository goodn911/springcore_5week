package com.sparta.springcore_homework.model;


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

    @OneToOne
    @JoinColumn(name="food_Id",nullable = false)
    private Food food;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long price;   //수량*1개음식 한가격

    public OrderFood(Food food, Long quantity, Long price) {
        if(quantity<1||quantity>100){
            throw new IllegalArgumentException("주문수량 허용 범위는 1~100개 사이입니다.");
        }

        this.food = food;
        this.quantity=quantity;
        this.price=price;
    }
}
