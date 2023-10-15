package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.dto.detail.color.ColorRequest;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;

import java.awt.*;
import java.util.List;
public interface ColorService {

    Boolean saveColor(ColorRequest color);
    ColorEntity getColorEntity(Long id);
    ColorResponse getColor(Long id);
    List<ColorResponse> showAllColor();

    //void deleteColor(List<Long> id);

}
