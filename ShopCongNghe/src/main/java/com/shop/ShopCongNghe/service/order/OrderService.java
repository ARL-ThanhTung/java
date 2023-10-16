package com.shop.ShopCongNghe.service.order;

import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.role.RoleEntity;

import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {

    Boolean saveOrder(OrderRequest order );
    List<OrderResponse> showAllOrderByUser(Long id);

}
