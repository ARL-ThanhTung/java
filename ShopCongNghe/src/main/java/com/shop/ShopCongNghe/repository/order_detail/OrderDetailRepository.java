package com.shop.ShopCongNghe.repository.order_detail;

import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
}
