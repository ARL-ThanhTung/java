package com.shop.ShopCongNghe.service.product.detail;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImageService  {
    ImageEntity saveImage(ImageEntity image);

    ImageEntity getImage(Long id);
    List<ImageEntity> showAllImage();

    void deleteImage(List<Long> id);


}
