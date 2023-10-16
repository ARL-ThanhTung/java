package com.shop.ShopCongNghe.service.order.impl;

import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.order.OrderRepository;
import com.shop.ShopCongNghe.service.order.OrderService;
import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Boolean saveOrder(OrderRequest order) {
        try {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(order.getId());
            orderEntity.setStatus(order.getStatus());
            orderEntity.setTotal_amount(order.getTotal_amount());
            UserEntity userEntity = userService.showUserEntiy(order.getUser_id());
            orderEntity.setUser(userEntity);
            orderRepository.save(orderEntity);
            return true;
        } catch(Exception e){
            System.out.println("Error service create");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public List<OrderResponse> showAllOrderByUser(Long id) {

        List<OrderEntity> orderEntity = orderRepository.findByUserId(id);


        return null;
    }
}
