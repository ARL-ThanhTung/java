package com.shop.ShopCongNghe.service.order_detail.impl;

import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;
import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;
import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.repository.order.OrderRepository;
import com.shop.ShopCongNghe.repository.order_detail.OrderDetailRepository;
import com.shop.ShopCongNghe.repository.product.ProductDetailRepository;
import com.shop.ShopCongNghe.service.order_detail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailRequest;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Boolean saveOrderDetail(OrderDetailRequest order_detail) {
        try {
            OrderDetailEntity order = new OrderDetailEntity();
            //order.setId(order_detail.getId());
            order.setInto_money(order_detail.getInto_money());
            order.setDate_note(order_detail.getDate_note());
            order.setQuantity(order_detail.getQuantity());
            ProductDetailEntity productDetailEntity = productDetailRepository.findById(order_detail.getProduct_detail_id()).get();
            OrderEntity orderEntity = orderRepository.findById(order_detail.getOrder_id()).get();
            order.setOrder(orderEntity);
            order.setProduct_detail(productDetailEntity);
            orderDetailRepository.save(order) ;
            return true;
        } catch(Exception e){
            System.out.println("Error service order detail create");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public List<OrderDetailResponse> showAllOrderDetail() {
        return null;
    }


}
