package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.repository.product.detail.CardRepository;
import com.shop.ShopCongNghe.service.product.detail.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardEntity saveCard(CardEntity card) {
        return cardRepository.save(card);
    }

    @Override
    public CardEntity getCard(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public List<CardEntity> showAllCard() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCard(List<Long> id) {
        try {
            for (Long cardId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                CardEntity existingCard = getCard(cardId);

                if (existingCard != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    cardRepository.delete(existingCard); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API image: delete");
        }
    }
}
