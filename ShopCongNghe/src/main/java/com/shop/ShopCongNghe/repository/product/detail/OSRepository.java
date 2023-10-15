package com.shop.ShopCongNghe.repository.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.OSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OSEntity,Long> {
}
