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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderRequest_Id", nullable = false)
    private List<OrderFood> orderFood;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_Id", nullable = false)
    private Restaurant restaurant;

    @Column
    private Long deliveryFee;

    @Column
    private Long totalPrice;  //음식총가격의 총합 + 배달비
//
//    public OrderEntity(Restaurant restaurant, List<OrderFood> orderFood,OrderFoodRequestDto orderFoodRequestDto,Food food){
//        this.orderFood=orderFood;
//        this.restaurant=restaurant;
//        this.deliveryFee= restaurant.getDeliveryFee();
//        this.totalPrice= orderFoodRequestDto.getQuantity()*food.getPrice()+restaurant.getDeliveryFee();
//
//    }

    public OrderEntity(List<OrderFood> orderFoods, Restaurant restaurant, Long price) {


        this.orderFood=orderFoods;
        this.restaurant=restaurant;
        this.deliveryFee= restaurant.getDeliveryFee();
        this.totalPrice= OrderValidator.validateOrderInput(restaurant,price);



    }
}
