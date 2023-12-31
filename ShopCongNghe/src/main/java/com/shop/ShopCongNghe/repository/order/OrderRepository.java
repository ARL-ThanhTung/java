package com.shop.ShopCongNghe.repository.order;


import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByUserId(Long userId , Sort sort );
}
