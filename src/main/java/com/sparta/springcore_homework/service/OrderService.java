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

import com.sparta.springcore_homework.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityRepository,FoodRepository foodRepository,RestaurantRepository restaurantRepository) {
        this.orderEntityRepository = orderEntityRepository;

        this.foodRepository=foodRepository;
        this.restaurantRepository=restaurantRepository;
    }
        //주문내역 DB에 저장 및 주문서 출력
        @Transactional
        public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
            //음식점찾기 유효검사
            Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                    ()->new IllegalArgumentException("음식점이 없습니다.")
            );
            //반환할 Dto 에 담길 리스트
            List<OrderFoodResponseDto> orderFoodResponseDtos = new ArrayList<>();
            //주문음식 내역
            List<OrderFood> orderFoods = new ArrayList<>();
            //총가격
            Long totalPrice =0L;

            //리스트로 Post 요청된 음식목록(음식 id,음식수량) 풀기
            for(OrderFoodRequestDto orderFoodRequestDto:orderRequestDto.getFoods()){

                //음식 id
                Long id= orderFoodRequestDto.getId();
                //음식정보(이름,가격,음식점 id)
                Food food = foodRepository.findById(id).orElseThrow(
                        ()->new IllegalArgumentException("음식이 없습니다.")
                );
                //음식수량
                Long quantity = orderFoodRequestDto.getQuantity();
                //음식가격*수량
                Long price=food.getPrice()*quantity;
                //총가격에 더하기
                totalPrice+=price ;
                //주문내역 객체 생성
                OrderFood orderFood = new OrderFood(food, quantity,price);
                //반환할 Dto에 담길 리스트에 넣을 객체 생성
                OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto(food.getName(),quantity,price);

                //반환할 dto 에 담길 리스트 추가
                orderFoodResponseDtos.add(orderFoodResponseDto);
                //FoodEntity 에 담길 주문음식내역 리스트 추가
                orderFoods.add(orderFood);




            }
            //주문서 객체 생성
            OrderEntity entity = new OrderEntity(orderFoods,restaurant,totalPrice);

            orderEntityRepository.save(entity);
            //반환할 DTO 생성
            OrderResponseDto orderResponseDto = new OrderResponseDto(restaurant.getName(),orderFoodResponseDtos, restaurant.getDeliveryFee(), entity.getTotalPrice());

            return  orderResponseDto;
    }

    //DB에 저장된 주문조회
    @Transactional
    public List<OrderResponseDto> getOrder() {
        //주문서에 담길 모든 정보찾기
        List<OrderEntity> orderEntitys = orderEntityRepository.findAll();
        //반환할 DTO 리스트 생성
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        //찾은 정보 객체에 주입
        for(OrderEntity orderEntity:orderEntitys){
            //주문서에 있는 주문내역 리스트
            List<OrderFoodResponseDto> orderFoodResponseDtos = new ArrayList<>();
            // 주문내역 리스트 객체에 정보 주입
            for ( OrderFood orderFood: orderEntity.getOrderFood() ){
                //주문음식
                String foodName= orderFood.getFood().getName();
                //주문 수량
                Long quantity = orderFood.getQuantity();
                //주문가격
                Long price = orderFood.getPrice();
                //주문내역 객체 생성
                OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto(foodName,quantity,price);
                //주문내역 리스트에 추가
                orderFoodResponseDtos.add(orderFoodResponseDto);
            }
            //주문서에 기재될 내용
            String restaurantName = orderEntity.getRestaurant().getName();
            Long deliveryFee = orderEntity.getDeliveryFee();
            Long totalprice = orderEntity.getTotalPrice();
            //반환할 주문서 DTO 객체 생성
            OrderResponseDto orderResponseDto = new OrderResponseDto(restaurantName,orderFoodResponseDtos,deliveryFee,totalprice);
            //반환할 DTO 리스트에 추가
            orderResponseDtoList.add(orderResponseDto);

        }
        return orderResponseDtoList;
    }

}
