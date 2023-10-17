package com.shop.ShopCongNghe.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.ShopCongNghe.entity.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //UserEntity findByPhoneNumber(String phoneNumber);

    UserEntity findByPhoneNumber(String phone);
}
