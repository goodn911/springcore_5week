package com.sparta.springcore_homework.model;



import com.sparta.springcore_homework.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
//주문서
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    //음식주문내역
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderRequest_Id", nullable = false)
    private List<OrderFood> orderFood;
    //음식점
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_Id", nullable = false)
    private Restaurant restaurant;
    //배달요금
    @Column
    private Long deliveryFee;

    @Column
    private Long totalPrice;  //음식총가격의 총합 + 배달비


    public OrderEntity(List<OrderFood> orderFoods, Restaurant restaurant, Long price) {


        this.orderFood=orderFoods;
        this.restaurant=restaurant;
        this.deliveryFee= restaurant.getDeliveryFee();
        //유효성검사 및 총가격
        this.totalPrice= OrderValidator.validateOrderInput(restaurant,price);



    }
}
