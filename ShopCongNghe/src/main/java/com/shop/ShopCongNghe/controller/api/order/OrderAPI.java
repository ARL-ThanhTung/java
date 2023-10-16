package com.shop.ShopCongNghe.controller.api.order;


import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.product.ProductRequest;
import com.shop.ShopCongNghe.dto.product.ProductResponse;
import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;

import java.util.List;

@RestController
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @PostMapping( "/orders" )
    public Boolean addProduct(@RequestBody OrderRequest orderRequest  ){
        try {
            return orderService.saveOrder( orderRequest );
        } catch (Exception e){
            System.out.println(e);
        }
        return false ;
    }

    @GetMapping("/orders")
    public List<OrderResponse> showOrderByUser(@PathVariable Long id){
        return orderService.showAllOrderByUser(id);
    }

}
