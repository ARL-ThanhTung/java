package com.shop.ShopCongNghe.service.product.impl;

import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;

import com.shop.ShopCongNghe.repository.product.ProductRepository;

import com.shop.ShopCongNghe.service.branch.BranchService;
import com.shop.ShopCongNghe.service.category.CategoryService;
import com.shop.ShopCongNghe.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.shop.ShopCongNghe.dto.category.CategoryResponse;
import com.shop.ShopCongNghe.dto.product.ProductResponse;
import com.shop.ShopCongNghe.dto.branch.BranchResponse;

import com.shop.ShopCongNghe.dto.product.ProductRequest ;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchService branchService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductEntity saveProduct(ProductRequest productRequest) {

        try {
            ProductEntity product = new ProductEntity();
            product.setTitle(productRequest.getTitle());
            product.setName(productRequest.getName());
            product.setDescription((productRequest.getDescription()));
            product.setImage(productRequest.getImage());

            BranchEntity exist_branch = branchService.getBranch(productRequest.getBranch_id());
            CategoryEntity exist_category = categoryService.getCategory(productRequest.getBranch_id());
            if( exist_branch != null ){
                System.out.println("aaa");
                product.checkBranch(exist_branch);
            }
            if( exist_category != null ){
                product.checkCategory(exist_category);
            }
            return productRepository.save(product);
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error API Product create");
        }
        return null ;
        //return productRepository.save(product);
    }

    @Override
    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductResponse> showAllProduct() {
        List<ProductResponse> productResponses = new ArrayList<>();
        List<ProductEntity> productEntity = productRepository.findAll();
        for( int i = 0 ; i < productEntity.size() ; i++ ){
            ProductResponse proRes = new ProductResponse();
            proRes.setId(productEntity.get(i).getId());
            proRes.setTitle( productEntity.get(i).getTitle() );
            proRes.setName( productEntity.get(i).getName() ) ;
            proRes.setDescription( productEntity.get(i).getDescription() );
            proRes.setImage( productEntity.get(i).getImage() );

            if (productEntity.get(i).getBranch() != null){
                BranchResponse branch = new BranchResponse();
                branch.setId( productEntity.get(i).getBranch().getId() );
                branch.setName( productEntity.get(i).getBranch().getName() );
                proRes.setBranch( branch );
            }
            if ( productEntity.get(i).getCategory() != null ){
                CategoryResponse category = new CategoryResponse();
                category.setId( productEntity.get(i).getCategory().getId() );
                category.setName( productEntity.get(i).getCategory().getName() );
                proRes.setCategory( category );
            }
            productResponses.add(proRes);
        }
        return productResponses ;
    }
}
