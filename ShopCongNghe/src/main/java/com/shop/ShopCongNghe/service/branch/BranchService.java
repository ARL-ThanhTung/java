package com.shop.ShopCongNghe.service.branch;


import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;

import java.util.List;

public interface BranchService {

    BranchEntity saveBranch(BranchEntity branch );

    BranchEntity getBranch(Long id);
    List<BranchEntity> showAllBranch();

    void deleteBranch(List<Long> id);

}
