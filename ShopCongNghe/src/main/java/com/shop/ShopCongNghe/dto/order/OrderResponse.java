package com.shop.ShopCongNghe.dto.order;

import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;
import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.user.UserEntity;

import java.util.ArrayList;
import java.util.List;


public class OrderResponse {

    private Long id;

    private float total_money;

    private Long status;

    private UserResponse user;

    private List<OrderDetailResponse> order_detail = new ArrayList<>();


    public List<OrderDetailResponse> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetailResponse> order_detail) {
        this.order_detail = order_detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
