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

//주문내역
public class OrderResponse {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "orderRequest_Id",nullable = false)
    private List<OrderRequest> OrderRequests;

//    @OneToMany
//    @JoinColumn(name = "restaurant_Id",nullable = false)
//    private List<Restaurant> restaurants;



}
