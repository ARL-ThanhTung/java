package com.shop.ShopCongNghe.service.user.impl;


import com.shop.ShopCongNghe.dto.role.RoleResponse;
import com.shop.ShopCongNghe.dto.user.UserRequest;
import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.user.UserRepository;
import com.shop.ShopCongNghe.service.role.RoleService;
import com.shop.ShopCongNghe.service.user.UserService;
import org.apache.catalina.User;
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
    public UserResponse saveUser(UserRequest user) {
        try {
            UserEntity userExist = userRepository.findByPhoneNumber(user.getPhone());
            if(userExist != null){
                UserResponse userResponse = new UserResponse();
                userResponse.setId(userExist.getId());
                userResponse.setAddress(userExist.getAddress());
                userResponse.setEmail(userExist.getEmail());
                userResponse.setFull_name(userExist.getFull_name());
                userResponse.setPassword(userExist.getPassword());
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setId(userExist.getRole().getId());
                roleResponse.setName(userExist.getRole().getName());
                userResponse.setRole(roleResponse);
                return userResponse;
            }

            UserEntity userEntity = new UserEntity();
            //userEntity.setId(user.getId());
            userEntity.setAddress(user.getAddress());
            userEntity.setEmail(user.getEmail());
            userEntity.setFull_name(user.getFull_name());
            userEntity.setPhoneNumber(user.getPhone());
            userEntity.setPassword(user.getPassword());
            RoleEntity roleEntity = roleService.showRole(user.getRole_id());
            userEntity.setRole(roleEntity);
            userRepository.save(userEntity);
            UserResponse userResponse = new UserResponse();
            userResponse.setId(userEntity.getId());
            userResponse.setAddress(userEntity.getAddress());
            userResponse.setEmail(userEntity.getEmail());
            userResponse.setFull_name(userEntity.getFull_name());
            userResponse.setPassword(userEntity.getPassword());
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(userEntity.getRole().getId());
            roleResponse.setName(userEntity.getRole().getName());
            userResponse.setRole(roleResponse);
            return userResponse;
        }catch(Exception e){
            System.out.println("Error API create user");
            System.out.println(e);
            return null;
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
            userResponse.setPassword((user.getPassword()));
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
