package com.shop.ShopCongNghe.controller.api.product;


import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.service.product.ProductService;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.ShopCongNghe.dto.product.ProductResponse;

import java.util.List;

import com.shop.ShopCongNghe.dto.product.ProductRequest ;

@RestController
public class ProductAPI {

    @Autowired
    private ProductService productService;


    @PostMapping( "/products" )
    public ProductEntity addProduct(@RequestBody ProductRequest productRequest  ){
        try {
            return productService.saveProduct( productRequest );
        } catch (Exception e){
            System.out.println(e);
        }
        return null ;
    }

    @GetMapping("/products")
    public List<ProductResponse> showCustomer(){
        return productService.showAllProduct();
    }


}


/*

{
  "description": "Điện Thoại Đắt Nhất Thế Giới",
  "image": "image",
  "name": "IPhone 15 Pro Max",
  "title": "IP15PRM"
}

 */