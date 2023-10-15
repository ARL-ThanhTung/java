package com.shop.ShopCongNghe.controller.api.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.OSEntity;
import com.shop.ShopCongNghe.service.product.detail.OSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OsAPI {
    @Autowired
    private OSService osService;

    @PostMapping("/oss")
    public OSEntity addCard(@RequestBody OSEntity ossEntity ){
        return osService.saveOS(ossEntity);
    }

    @GetMapping("/oss/{id}")
    public OSEntity getCard(@PathVariable Long id){
        return osService.getOS(id)  ;
    }

    @GetMapping("/oss")
    public List<OSEntity> getAllCard(){
        return osService.showAllOS();
    }

    @DeleteMapping("/oss")
    public void deleteCard(@RequestBody List<Long> id){
        osService.deleteOS(id);
    }
}
