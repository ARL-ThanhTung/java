package com.shop.ShopCongNghe.service.product.detail.impl;


import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import com.shop.ShopCongNghe.entity.product.detail.RomEntity;
import com.shop.ShopCongNghe.repository.product.detail.RomRepository;
import com.shop.ShopCongNghe.service.product.detail.RomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RomServiceImpl implements RomService {
    @Autowired
    private RomRepository romRepository;

    @Override
    public RomEntity saveRom(RomEntity rom) {
        return romRepository.save(rom);
    }

    @Override
    public RomEntity getRom(Long id) {
        return romRepository.findById(id).get();
    }

    @Override
    public List<RomEntity> showAllRom() {
        return romRepository.findAll();
    }

    @Override
    public void deleteRom(List<Long> id) {
        try {
            for (Long romId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                RomEntity existingRom = getRom(romId);

                if (existingRom != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    romRepository.delete(existingRom); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API image: delete");
        }
    }
}
