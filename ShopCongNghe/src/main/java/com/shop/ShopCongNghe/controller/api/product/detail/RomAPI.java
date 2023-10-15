package com.shop.ShopCongNghe.controller.api.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import com.shop.ShopCongNghe.entity.product.detail.RomEntity;
import com.shop.ShopCongNghe.service.product.detail.RamService;
import com.shop.ShopCongNghe.service.product.detail.RomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RomAPI {
    @Autowired
    private RomService romService;

    @PostMapping("/roms")
    public RomEntity addCard(@RequestBody RomEntity romEntity ){
        return romService.saveRom(romEntity);
    }

    @GetMapping("/roms/{id}")
    public RomEntity getCard(@PathVariable Long id){
        return romService.getRom(id)  ;
    }

    @GetMapping("/roms")
    public List<RomEntity> getAllCard(){
        return romService.showAllRom();
    }

    @DeleteMapping("/roms")
    public void deleteCard(@RequestBody List<Long> id){
        romService.deleteRom(id);
    }
}
