package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.entity.product.detail.RamEntity;

import java.util.List;

public interface RamService {
    RamEntity saveRam(RamEntity ram);

    RamEntity getRam(Long id);
    List<RamEntity> showAllRam();

    void deleteRam(List<Long> id);
}
