package com.shop.ShopCongNghe.service.order_detail;

import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;

import java.util.List;

public interface OrderDetailService {
    OrderDetailEntity saveOrder(OrderDetailEntity order_detail );
    List<OrderDetailEntity> showAllOrderDetail();
}
