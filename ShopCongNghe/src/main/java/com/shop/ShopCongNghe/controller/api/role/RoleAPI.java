package com.shop.ShopCongNghe.controller.api.role;

import com.shop.ShopCongNghe.dto.product.ProductRequest;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleAPI {
    @Autowired
    private RoleService roleService;
    @PostMapping( "/roles" )
    public RoleEntity addRole(RoleEntity roleEntity){
        try {
            return roleService.saveRole( roleEntity );
        } catch (Exception e){
            System.out.println(e);
        }
        return null ;
    }

    @GetMapping("/roles")
    public List<RoleEntity> showRole(){
        return roleService.showAllRole();
    }
}
