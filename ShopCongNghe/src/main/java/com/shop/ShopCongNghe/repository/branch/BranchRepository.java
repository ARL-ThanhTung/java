package com.shop.ShopCongNghe.repository.branch;


import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Long> {
}
