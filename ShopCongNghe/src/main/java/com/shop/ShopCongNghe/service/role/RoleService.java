package com.shop.ShopCongNghe.service.role;



import com.shop.ShopCongNghe.entity.role.RoleEntity;

import java.util.List;

public interface RoleService {

    RoleEntity saveRole(RoleEntity role );
    List<RoleEntity> showAllRole();

    RoleEntity showRole(Long id);

}
