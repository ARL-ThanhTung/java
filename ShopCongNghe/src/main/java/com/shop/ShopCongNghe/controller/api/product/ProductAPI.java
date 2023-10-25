package com.shop.ShopCongNghe.controller.api.product;


import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.service.product.ProductService;
import com.shop.ShopCongNghe.service.product.detail.ColorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.ShopCongNghe.dto.product.ProductResponse;

import java.util.List;
import java.util.Optional;
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
    public List<ProductResponse> showProductAll(@RequestParam(value="name" , required = false) String name,
                                                @RequestParam(value="minPrice", required = false ) Float minPrice ,
                                                @RequestParam(value="maxPrice", required = false ) Float maxPrice){
        return productService.showAllProduct(name , minPrice , maxPrice);
    }

//    @GetMapping("/products")
//    public List<ProductResponse> showProductAll(){
//        return productService.showAllProduct();
//    }

    @GetMapping("/products/category/{id}")
    public List<ProductResponse> showProductAllCategory(@PathVariable Long id ){
        return productService.showAllProductCategory(id);
    }

    @GetMapping("/products/{id}")
    public ProductResponse showProduct(@PathVariable Long id){
        return productService.showProductById(id);
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