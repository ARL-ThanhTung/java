package com.shop.ShopCongNghe.dto.product;

import com.shop.ShopCongNghe.dto.branch.BranchResponse;
import com.shop.ShopCongNghe.dto.category.CategoryResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;

import java.util.List;

public class ProductResponse {

    private Long id;
    
    private String title;

    private String origin;


    private String name;

    private String image;

    private String description;

    private BranchResponse branch;

    private CategoryResponse category;

    private List<ProductDetailResponse> product_detail;

    public List<ProductDetailResponse> getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(List<ProductDetailResponse> product_detail) {
        this.product_detail = product_detail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BranchResponse getBranch() {
        return branch;
    }

    public void setBranch(BranchResponse branch) {
        this.branch = branch;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }
}
