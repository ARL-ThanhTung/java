package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.dto.detail.color.ColorRequest;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.repository.product.detail.ColorRepository;
import com.shop.ShopCongNghe.repository.product.detail.ImageRepository;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import com.shop.ShopCongNghe.repository.product.* ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Boolean saveColor(ColorRequest color) {
        try{
            ColorEntity colorEntity = new ColorEntity();
            colorEntity.setName(color.getName());
            colorEntity.setImage_link(color.getImage_link());
            colorRepository.save(colorEntity);
            return true;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public ColorEntity getColorEntity(Long id) {
        try{
            return colorRepository.findById(id).get();
        }catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ColorResponse getColor(Long id) {
        try {
            ColorEntity colorEntity = colorRepository.findById( id ).get();
            ColorResponse colorResponse = new ColorResponse();
            colorResponse.setId( colorEntity.getId() );
            colorResponse.setName(colorEntity.getName());
            colorResponse.setImage_link(colorEntity.getImage_link());
            return colorResponse;
        }catch(Exception e){
            System.out.println();
            return null;
        }
    }

    @Override
    public List<ColorResponse> showAllColor() {
        try {
            List<ColorEntity> colorEntity = colorRepository.findAll();
            List<ColorResponse> colorResponse = new ArrayList<>();
            for( int i = 0 ; i < colorEntity.size() ; i++ ){
                ColorResponse colorResponse1 = new ColorResponse();
                colorResponse1.setId( colorEntity.get(i).getId() );
                colorResponse1.setName(colorEntity.get(i).getName());
                colorResponse1.setImage_link(colorEntity.get(i).getImage_link());
                colorResponse.add(colorResponse1);
            }
            return colorResponse;
        }catch(Exception e){
            System.out.println();
            return null;
        }
    }

//    @Override
//    public void deleteColor(List<Long> id) {
//        try {
//            for (Long colorId : id) {
//                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
//                ColorEntity existingColor = getColor(colorId);
//
//                if (existingColor != null) {
//                    // Xóa existingImage từ cơ sở dữ liệu
//                    colorRepository.delete(existingColor); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
//                } else {
//                    System.out.println("");
//                }
//            }
//
//        } catch(Exception e){
//            System.out.println("Error API image: delete");
//        }
//    }
}
