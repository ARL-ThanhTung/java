package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.repository.product.detail.ImageRepository;
import com.shop.ShopCongNghe.service.product.detail.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ImageEntity saveImage(ImageEntity image) {
        return imageRepository.save(image);
    }

    @Override
    public ImageEntity getImage(Long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public List<ImageEntity> showAllImage() {
        return imageRepository.findAll();
    }

    @Override
    public void deleteImage(List<Long> id) {
        try {
            for (Long imageId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                ImageEntity existingImage = getImage(imageId);

                if (existingImage != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    imageRepository.delete(existingImage); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API image: delete");
        }


    }
}
