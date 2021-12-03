package com.sparta.springcore_homework.service;

import com.sparta.springcore_homework.dto.OrderFoodRequestDto;
import com.sparta.springcore_homework.dto.OrderFoodResponseDto;
import com.sparta.springcore_homework.dto.OrderRequestDto;
import com.sparta.springcore_homework.dto.OrderResponseDto;
import com.sparta.springcore_homework.model.Food;
import com.sparta.springcore_homework.model.OrderEntity;
import com.sparta.springcore_homework.model.OrderFood;
import com.sparta.springcore_homework.model.Restaurant;
import com.sparta.springcore_homework.repository.FoodRepository;
import com.sparta.springcore_homework.repository.OrderEntityRepository;
import com.sparta.springcore_homework.repository.OrderFoodRepository;
import com.sparta.springcore_homework.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    private final OrderFoodRepository orderFoodRepository;
    private final OrderEntityRepository orderEntityRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityRepository, OrderFoodRepository orderFoodRepository,FoodRepository foodRepository,RestaurantRepository restaurantRepository) {
        this.orderEntityRepository = orderEntityRepository;
        this.orderFoodRepository = orderFoodRepository;
        this.foodRepository=foodRepository;
        this.restaurantRepository=restaurantRepository;
    }
        @Transactional
        public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

            Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                    ()->new IllegalArgumentException("음식점이 없습니다.")
            );

            List<OrderFoodResponseDto> orderFoodResponseDtos = new ArrayList<>(); //반환할 dto
            List<OrderFood> orderFoods = new ArrayList<>();

            Long totalPrice =0L;
            for(OrderFoodRequestDto orderFoodRequestDto:orderRequestDto.getFoods()){
                Long id= orderFoodRequestDto.getId();



                Food food = foodRepository.findById(id).orElseThrow(
                        ()->new IllegalArgumentException("음식이 없습니다.")
                );  //음식
                Long quantity = orderFoodRequestDto.getQuantity();
                Long price=food.getPrice()*quantity;
                totalPrice+=price ;

                OrderFood orderFood = new OrderFood(food, quantity,price);

                OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto(food.getName(),quantity,price);




                orderFoodResponseDtos.add(orderFoodResponseDto);
                orderFoods.add(orderFood); //리스트로 만듬




            }
            OrderEntity entity = new OrderEntity(orderFoods,restaurant,totalPrice);

            orderEntityRepository.save(entity);
            OrderResponseDto orderResponseDto = new OrderResponseDto(restaurant.getName(),orderFoodResponseDtos, restaurant.getDeliveryFee(), entity.getTotalPrice());

            return  orderResponseDto;
    }
    public List<OrderResponseDto> getOrder() {
        List<OrderEntity> orderEntitys = orderEntityRepository.findAll();

        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        for(OrderEntity orderEntity:orderEntitys){
            List<OrderFoodResponseDto> orderFoodResponseDtos = new ArrayList<>();

            for ( OrderFood orderFood: orderEntity.getOrderFood() ){

                String foodName= orderFood.getFood().getName();
                Long quantity = orderFood.getQuantity();
                Long price = orderFood.getPrice();

                OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto(foodName,quantity,price);
                orderFoodResponseDtos.add(orderFoodResponseDto);
            }

            String restaurantName = orderEntity.getRestaurant().getName();
            Long deliveryFee = orderEntity.getDeliveryFee();
            Long totalprice = orderEntity.getTotalPrice();

            OrderResponseDto orderResponseDto = new OrderResponseDto(restaurantName,orderFoodResponseDtos,deliveryFee,totalprice);
            orderResponseDtoList.add(orderResponseDto);

        }
        return orderResponseDtoList;
    }

}
