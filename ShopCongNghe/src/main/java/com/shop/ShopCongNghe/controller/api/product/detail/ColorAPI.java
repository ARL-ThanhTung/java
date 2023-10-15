package com.shop.ShopCongNghe.controller.api.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.ShopCongNghe.service.product.*;
import java.util.List;

import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorRequest;
@RestController
public class ColorAPI {

    @Autowired
    private ColorService colorService;

    @PostMapping("/colors")
    public Boolean addColor(@RequestBody ColorRequest colorRequest ){
        try{
            colorService.saveColor(colorRequest);
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @GetMapping("/colors/{id}")
    public ColorResponse getColor(@PathVariable Long id){
        return colorService.getColor(id)  ;
    }

    @GetMapping("/colors")
    public List<ColorResponse> getAllColor(){
        return colorService.showAllColor();
    }

//    @DeleteMapping("/colors")
//    public void deleteColor(@RequestBody List<Long> id){
//        colorService.deleteColor(id);
//    }
}
