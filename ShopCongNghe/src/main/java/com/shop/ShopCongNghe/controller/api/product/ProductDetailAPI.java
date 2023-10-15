package com.shop.ShopCongNghe.controller.api.product;

import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.service.product.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import java.util.List;

import com.shop.ShopCongNghe.dto.productdetail.ProductDetailRequest;

@RestController
public class ProductDetailAPI {

    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping( "/productdetails" )
    public ProductDetailEntity addProductDetail(@RequestBody ProductDetailRequest productDetailRequest){
        try {
            return productDetailService.saveProductDetail(productDetailRequest );
        } catch (Exception e){
            System.out.println(e);
        }
        return null ;
    }

    @GetMapping("/productdetails")
    public List<ProductDetailResponse> showProductDetailAll(){
        return productDetailService.showAllProductDetail();
    }

    @GetMapping("/productdetails/{id}")
    public ProductDetailResponse showProductDetail(@PathVariable Long id){
        return productDetailService.showProductDetail(id);
    }

}

/*

{
  "battery": "4400mah",
  "camera": "15mp",
  "cameraSelf": "12mp",
  "description": "Chất Lượng",
  "price": 44000000
}

 */