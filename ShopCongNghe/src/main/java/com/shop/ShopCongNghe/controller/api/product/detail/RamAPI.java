package com.shop.ShopCongNghe.controller.api.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import com.shop.ShopCongNghe.entity.product.detail.OSEntity;
import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import com.shop.ShopCongNghe.service.product.detail.OSService;
import com.shop.ShopCongNghe.service.product.detail.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RamAPI {
    @Autowired
    private RamService ramService;

    @PostMapping("/rams")
    public RamEntity addCard(@RequestBody RamEntity ramEntity ){
        return ramService.saveRam(ramEntity);
    }

    @GetMapping("/rams/{id}")
    public RamEntity getCard(@PathVariable Long id){
        return ramService.getRam(id)  ;
    }

    @GetMapping("/rams")
    public List<RamEntity> getAllCard(){
        return ramService.showAllRam();
    }

    @DeleteMapping("/rams")
    public void deleteCard(@RequestBody List<Long> id){
        ramService.deleteRam(id);
    }

}
