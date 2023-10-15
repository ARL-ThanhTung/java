package com.shop.ShopCongNghe.service.category;

import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity saveCategory(CategoryEntity category );

    CategoryEntity getCategory(Long id);
    List<CategoryEntity> showAllCategory();

    void deleteCategory(List<Long> id);
}
