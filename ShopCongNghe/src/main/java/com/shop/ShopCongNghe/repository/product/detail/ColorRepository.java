package com.shop.ShopCongNghe.repository.product.detail;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
}
