package com.shop.ShopCongNghe.controller.api.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.ShopCongNghe.service.product.*;
import java.util.List;


@RestController
public class ColorAPI {

    @Autowired
    private ColorService colorService;

    @PostMapping("/colors")
    public ColorEntity addColor(@RequestBody ColorEntity colorEntity ){
        return colorService.saveColor(colorEntity);
    }

    @GetMapping("/colors/{id}")
    public ColorEntity getColor(@PathVariable Long id){
        return colorService.getColor(id)  ;
    }

    @GetMapping("/colors")
    public List<ColorEntity> getAllColor(){
        return colorService.showAllColor();
    }

    @DeleteMapping("/colors")
    public void deleteColor(@RequestBody List<Long> id){
        colorService.deleteColor(id);
    }
}
