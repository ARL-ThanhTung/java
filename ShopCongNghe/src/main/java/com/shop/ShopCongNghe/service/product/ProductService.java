package com.shop.ShopCongNghe.service.product;

import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;
import com.shop.ShopCongNghe.dto.product.ProductRequest ;

import com.shop.ShopCongNghe.dto.product.ProductResponse;


public interface ProductService {

    ProductEntity saveProduct( ProductRequest productRequest );

    ProductEntity getProduct( Long id );
    List<ProductResponse> showAllProduct();

}
