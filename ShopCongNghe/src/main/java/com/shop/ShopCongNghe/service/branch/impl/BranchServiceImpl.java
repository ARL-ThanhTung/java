package com.shop.ShopCongNghe.service.branch.impl;


import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.repository.branch.BranchRepository;
import com.shop.ShopCongNghe.service.branch.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {


    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BranchEntity saveBranch(BranchEntity branch) {
        return branchRepository.save(branch);
    }

    @Override
    public BranchEntity getBranch(Long id) {
        try {
            return branchRepository.findById(id).get();
        } catch( Exception e ){
            System.out.println("Error API create Branch");
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<BranchEntity> showAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public void deleteBranch(List<Long> id) {
        try {
            for (Long branchId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                BranchEntity existingBranch = getBranch(branchId);

                if (existingBranch != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    branchRepository.delete(existingBranch); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API branch: delete");
        }
    }
}
