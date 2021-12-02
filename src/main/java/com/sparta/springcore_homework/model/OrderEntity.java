package com.sparta.springcore_homework.model;


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

    @OneToMany
    @JoinColumn(name = "orderRequest_Id", nullable = false)
    private List<OrderFood> orderFood;

    @ManyToOne
    @JoinColumn(name = "restaurant_Id", nullable = false)
    private Restaurant restaurant;

    @Column
    private Long deliveryFee;

    @Column
    private Long totalPrice;  //음식총가격의 총합 + 배달비
}
