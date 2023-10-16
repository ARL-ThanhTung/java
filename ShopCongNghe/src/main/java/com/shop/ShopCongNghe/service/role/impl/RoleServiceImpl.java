package com.shop.ShopCongNghe.service.role.impl;

import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.repository.role.RoleRepository;
import com.shop.ShopCongNghe.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public List<RoleEntity> showAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity showRole(Long id) {
        return roleRepository.findById(id).get();
    }
}
