package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.repository.product.detail.ColorRepository;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import com.shop.ShopCongNghe.repository.product.* ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public ColorEntity saveColor(ColorEntity color) {
        return colorRepository.save(color);
    }

    @Override
    public ColorEntity getColor(Long id) {
        return colorRepository.findById( id ).get();
    }

    @Override
    public List<ColorEntity> showAllColor() {
        return colorRepository.findAll();
    }

    @Override
    public void deleteColor(List<Long> id) {
        try {
            for (Long colorId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                ColorEntity existingColor = getColor(colorId);

                if (existingColor != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    colorRepository.delete(existingColor); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API image: delete");
        }
    }
}
