package com.shop.ShopCongNghe.controller.api.category;


import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import com.shop.ShopCongNghe.service.category.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @PostMapping( "/categorys" )
    public CategoryEntity addBranch(@RequestBody CategoryEntity categoryEntity  ){
        return categoryService.saveCategory(categoryEntity );
    }

    @GetMapping("/categorys/{id}")
    public CategoryEntity getCategory(@PathVariable Long id){
        return categoryService.getCategory(id)  ;
    }

    @GetMapping("/categorys")
    public List<CategoryEntity> showAllCategory(){
        return categoryService.showAllCategory();
    }

    @DeleteMapping("/categorys")
    public void deleteCategory(@RequestBody List<Long> id){
        categoryService.deleteCategory(id);
    }

}
