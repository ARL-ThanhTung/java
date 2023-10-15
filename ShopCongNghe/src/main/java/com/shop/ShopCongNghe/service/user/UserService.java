package com.shop.ShopCongNghe.service.user;

import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity user );
    List<UserEntity> showAllUser();


}
