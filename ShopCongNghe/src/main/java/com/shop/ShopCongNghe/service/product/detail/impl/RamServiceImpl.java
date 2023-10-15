package com.shop.ShopCongNghe.service.product.detail.impl;

import com.shop.ShopCongNghe.entity.product.detail.ImageEntity;
import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import com.shop.ShopCongNghe.repository.product.detail.RamRepository;
import com.shop.ShopCongNghe.service.product.detail.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamServiceImpl implements RamService {
    @Autowired
    private RamRepository ramRepository;
    @Override
    public RamEntity saveRam(RamEntity ram) {
        return ramRepository.save(ram);
    }

    @Override
    public RamEntity getRam(Long id) {
        return ramRepository.findById(id).get();
    }

    @Override
    public List<RamEntity> showAllRam() {
        return ramRepository.findAll();
    }

    @Override
    public void deleteRam(List<Long> id) {
        try {
            for (Long ramId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                RamEntity existingRam = getRam(ramId);

                if (existingRam != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    ramRepository.delete(existingRam); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API image: delete");
        }
    }
}
