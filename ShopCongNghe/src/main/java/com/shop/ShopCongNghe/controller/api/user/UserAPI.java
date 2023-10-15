package com.shop.ShopCongNghe.controller.api.user;

import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;


@RestController
public class UserAPI {

    @Autowired
    private UserService customerService;


    @PostMapping( "/users" )
    public UserEntity addCustomer(@RequestBody UserEntity customer ){
        return customerService.saveUser(customer);
    }

    @GetMapping("/users")
    public List<UserEntity> showCustomer(){
        return customerService.showAllUser();
    }

}
