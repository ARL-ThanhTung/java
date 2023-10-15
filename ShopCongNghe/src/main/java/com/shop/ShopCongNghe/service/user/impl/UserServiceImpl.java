package com.shop.ShopCongNghe.service.user.impl;


import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.user.UserRepository;
import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> showAllUser() {
        return userRepository.findAll();
    }
}
