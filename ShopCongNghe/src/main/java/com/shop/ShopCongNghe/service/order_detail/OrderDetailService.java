package com.shop.ShopCongNghe.service.order_detail;

import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;

import com.shop.ShopCongNghe.dto.order_detail.OrderDetailRequest;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;


import java.util.List;

public interface OrderDetailService {
    Boolean saveOrderDetail(OrderDetailRequest order_detail );
    List<OrderDetailResponse> showAllOrderDetail();
}
