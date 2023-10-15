package com.shop.ShopCongNghe.service.order;

import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.role.RoleEntity;

import java.util.List;

public interface OrderService {

    OrderEntity saveOrder(OrderEntity order );
    List<OrderEntity> showAllOrder();

}
