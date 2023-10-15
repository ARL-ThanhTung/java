package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;

import java.awt.*;
import java.util.List;
public interface ColorService {

    ColorEntity saveColor(ColorEntity color);

    ColorEntity getColor(Long id);
    List<ColorEntity> showAllColor();

    void deleteColor(List<Long> id);

}
