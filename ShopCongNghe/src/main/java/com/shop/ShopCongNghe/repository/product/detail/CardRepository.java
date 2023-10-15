package com.shop.ShopCongNghe.repository.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity , Long> {
}
