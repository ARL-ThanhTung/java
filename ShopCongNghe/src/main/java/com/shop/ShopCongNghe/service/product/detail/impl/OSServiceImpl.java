package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.entity.product.detail.OSEntity;
import com.shop.ShopCongNghe.repository.product.detail.OSRepository;
import com.shop.ShopCongNghe.service.product.detail.OSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OSServiceImpl implements OSService {

    @Autowired
    private OSRepository osRepository;

    @Override
    public OSEntity saveOS(OSEntity os) {
        return osRepository.save(os);
    }

    @Override
    public OSEntity getOS(Long id) {
        return osRepository.findById(id).get();
    }

    @Override
    public List<OSEntity> showAllOS() {
        return osRepository.findAll();
    }

    @Override
    public void deleteOS(List<Long> id) {
        try {
            for (Long osId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                OSEntity existingOS = getOS(osId);

                if (existingOS != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    osRepository.delete(existingOS); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API os: delete");
        }
    }
}
