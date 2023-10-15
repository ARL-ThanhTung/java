package com.shop.ShopCongNghe.controller.api.branch;


import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.service.branch.BranchService;
import com.shop.ShopCongNghe.service.category.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BranchAPI {

    @Autowired
    private BranchService branchService;

    @PostMapping( "/branchs" )
    public BranchEntity addBranch(@RequestBody BranchEntity branchEntity  ){
        return branchService.saveBranch(branchEntity);
    }

    @GetMapping("/branchs/{id}")
    public BranchEntity getCategory(@PathVariable Long id){
        return branchService.getBranch(id)  ;
    }

    @GetMapping("/branchs")
    public List<BranchEntity> showAllCategory(){
        return branchService.showAllBranch();
    }

    @DeleteMapping("/branchs")
    public void deleteCategory(@RequestBody List<Long> id){
        branchService.deleteBranch(id);
    }

}
