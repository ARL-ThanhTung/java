package com.shop.ShopCongNghe.repository.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RamRepository extends JpaRepository<RamEntity,Long> {
}
