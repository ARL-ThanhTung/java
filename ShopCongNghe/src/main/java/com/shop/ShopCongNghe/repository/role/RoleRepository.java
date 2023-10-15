package com.shop.ShopCongNghe.repository.role;

import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
