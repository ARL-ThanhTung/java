package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;

import java.util.List;

public interface CardService {
    CardEntity saveCard(CardEntity card);

    CardEntity getCard(Long id);
    List<CardEntity> showAllCard();

    void deleteCard(List<Long> id);
}
