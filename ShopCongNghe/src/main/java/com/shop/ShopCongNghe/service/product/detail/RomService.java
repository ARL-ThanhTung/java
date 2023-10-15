package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.entity.product.detail.RomEntity;

import java.util.List;

public interface RomService {
    RomEntity saveRom(RomEntity rom);

    RomEntity getRom(Long id);
    List<RomEntity> showAllRom();

    void deleteRom(List<Long> id);
}
