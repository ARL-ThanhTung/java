package com.shop.ShopCongNghe.controller.api.order_detail;

import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailRequest;
import com.shop.ShopCongNghe.service.order.OrderService;
import com.shop.ShopCongNghe.service.order_detail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailRequest;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;
@RestController
public class OrderDeatilAPI {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping( "/order_details" )
    public Boolean addOrder(@RequestBody OrderDetailRequest orderDetailRequest  ){
        try {
            return orderDetailService.saveOrderDetail( orderDetailRequest );
        } catch (Exception e){
            System.out.println(e);
        }
        return false ;
    }

//    @GetMapping("/orders/{id}")
//    public List<OrderDetailResponse> showOrderByUser(@PathVariable Long id){
//        return orderService.showAllOrderByUser(id);
//    }
}
