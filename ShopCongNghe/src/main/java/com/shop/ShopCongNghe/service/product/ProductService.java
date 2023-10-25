package com.shop.ShopCongNghe.service.product;

import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;
import com.shop.ShopCongNghe.dto.product.ProductRequest ;

import com.shop.ShopCongNghe.dto.product.ProductResponse;
import java.util.Optional;

public interface ProductService {

    ProductEntity saveProduct( ProductRequest productRequest );
    ProductEntity getProduct( Long id );

    List<ProductResponse> showAllProduct(String name , Float minPrice , Float maxPrice);
    //List<ProductResponse> showAllProduct();

    List<ProductResponse> showAllProductCategory(long id);

    ProductResponse showProductById(Long id);

}
