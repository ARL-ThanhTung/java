package com.shop.ShopCongNghe.service.user.impl;


import com.shop.ShopCongNghe.dto.role.RoleResponse;
import com.shop.ShopCongNghe.dto.user.UserRequest;
import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.user.UserRepository;
import com.shop.ShopCongNghe.service.role.RoleService;
import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public Boolean saveUser(UserRequest user) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setAddress(user.getAddress());
            userEntity.setEmail(user.getEmail());
            userEntity.setFull_name(user.getFull_name());
            userEntity.setPhone_number(user.getPhone());
            userEntity.setPassword(user.getPassword());
            RoleEntity roleEntity = roleService.showRole(user.getRole_id());
            userEntity.setRole(roleEntity);
            userRepository.save(userEntity);
            return true;
        }catch(Exception e){
            System.out.println("Error API create user");
            System.out.println(e);
            return false;
        }
    }

//    @Override
//    public List<UserResponse> showAllUser() {
//        try {
//
//        }catch(Exception e){
//            System.out.println("Error get list user");
//            System.out.println(e);
//        }
//        return userRepository.findAll();
//    }

    @Override
    public UserResponse showUser(Long id) {
        try {
            UserEntity user = userRepository.findById(id).get();
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setAddress(user.getAddress());
            userResponse.setEmail(user.getEmail());
            userResponse.setFull_name(user.getFull_name());
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(user.getRole().getId());
            roleResponse.setName(user.getRole().getName());
            userResponse.setRole(roleResponse);
            return userResponse;
        }catch(Exception e){
            System.out.println("Error get list user");
            System.out.println(e);
            return null;
        }

    }

    @Override
    public UserEntity showUserEntiy(Long id) {
        return userRepository.findById(id).get();
    }
}
