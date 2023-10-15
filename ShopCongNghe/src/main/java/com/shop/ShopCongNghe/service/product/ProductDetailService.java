package com.shop.ShopCongNghe.service.product;


import com.shop.ShopCongNghe.dto.productdetail.ProductDetailRequest;
import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import java.util.List;

public interface ProductDetailService {
    Boolean saveProductDetail(ProductDetailRequest productDetailRequest );
    List<ProductDetailResponse> showAllProductDetail();
    ProductDetailResponse showProductDetail(Long id);
}
