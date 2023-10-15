package com.shop.ShopCongNghe.service.category.impl;


import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.repository.category.CategoryRepository;
import com.shop.ShopCongNghe.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        try {
            return categoryRepository.save(category);
        } catch (Exception e){
            System.out.println(e);
        }
        return null ;
    }

    @Override
    public CategoryEntity getCategory(Long id) {
        try {
            return categoryRepository.findById(id).get();
        } catch( Exception e ){
            System.out.println("Error API create category");
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<CategoryEntity> showAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(List<Long> id) {
        try {
            for (Long categoryId : id) {
                // Kiểm tra xem id có tồn tại trong cơ sở dữ liệu hay không
                CategoryEntity existingCategory = getCategory(categoryId);

                if (existingCategory != null) {
                    // Xóa existingImage từ cơ sở dữ liệu
                    categoryRepository.delete(existingCategory); // Sử dụng repository hoặc EntityManager tùy theo cách bạn quản lý dữ liệu
                } else {
                    System.out.println("");
                }
            }

        } catch(Exception e){
            System.out.println("Error API category: delete");
        }
    }
}
