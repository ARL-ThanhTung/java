package com.shop.ShopCongNghe.controller.api.user;

import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;
import com.shop.ShopCongNghe.dto.user.UserRequest;
import com.shop.ShopCongNghe.dto.user.UserResponse;

@RestController
public class UserAPI {

    @Autowired
    private UserService customerService;


    @PostMapping( "/users" )
    public UserResponse addCustomer(@RequestBody UserRequest user ){
        return customerService.saveUser(user);
    }

//    @GetMapping("/users")
//    public List<UserEntity> showCustomer(){
//        return customerService.showAllUser();
//    }
    @GetMapping("/users/{id}")
    public UserResponse showUser(@PathVariable Long id){
        return customerService.showUser(id);
    }
}
