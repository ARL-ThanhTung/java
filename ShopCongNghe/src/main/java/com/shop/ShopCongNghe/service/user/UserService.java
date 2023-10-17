package com.shop.ShopCongNghe.service.user;

import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;
import com.shop.ShopCongNghe.dto.user.UserRequest;

public interface UserService {

    UserResponse saveUser(UserRequest user );
    //List<UserEntity> showAllUser();

    UserResponse showUser(Long id);

    UserEntity showUserEntiy( Long id );
}
