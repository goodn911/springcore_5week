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
public class OrderRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long restaurantId;

    @OneToMany
    @JoinColumn(name="food_Id",nullable = false)
    private List<Food> foods;

    @Column(nullable = false)
    private Long quantity;




}
