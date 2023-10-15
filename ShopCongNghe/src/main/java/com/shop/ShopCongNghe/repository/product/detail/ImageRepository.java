package com.shop.ShopCongNghe.repository.product.detail;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Long> {

}
