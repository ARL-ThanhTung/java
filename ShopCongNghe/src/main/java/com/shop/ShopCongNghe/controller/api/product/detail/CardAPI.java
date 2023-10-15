package com.shop.ShopCongNghe.controller.api.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.service.product.detail.CardService;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardAPI {

    @Autowired
    private CardService cardService;

    @PostMapping("/cards")
    public CardEntity addCard(@RequestBody CardEntity cardEntity ){
        return cardService.saveCard(cardEntity);
    }

    @GetMapping("/cards/{id}")
    public CardEntity getCard(@PathVariable Long id){
        return cardService.getCard(id)  ;
    }

    @GetMapping("/cards")
    public List<CardEntity> getAllCard(){
        return cardService.showAllCard();
    }

    @DeleteMapping("/cards")
    public void deleteCard(@RequestBody List<Long> id){
        cardService.deleteCard(id);
    }
}
