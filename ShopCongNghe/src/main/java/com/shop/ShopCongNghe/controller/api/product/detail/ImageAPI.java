package com.shop.ShopCongNghe.controller.api.product.detail;


import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.service.product.detail.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageAPI {

    @Autowired
    private ImageService imageService;

    @PostMapping("/images")
    public ImageEntity addImage(@RequestBody ImageEntity imageEntity ){
        return imageService.saveImage(imageEntity);
    }

    @GetMapping("/images/{id}")
    public ImageEntity getImage(@PathVariable Long id){
        return imageService.getImage(id)  ;
    }

    @GetMapping("/images")
    public List<ImageEntity> getAllImage(){
        return imageService.showAllImage();
    }

    @DeleteMapping("/images")
    public void deleteImage(@RequestBody List<Long> id){
        imageService.deleteImage(id);
    }

}
