package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.entity.product.detail.OSEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OSService {
    OSEntity saveOS(OSEntity os);

    OSEntity getOS(Long id);
    List<OSEntity> showAllOS();

    void deleteOS(List<Long> id);
}
