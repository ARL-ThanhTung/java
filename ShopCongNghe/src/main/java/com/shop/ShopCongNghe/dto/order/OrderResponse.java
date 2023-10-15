package com.shop.ShopCongNghe.dto.order;

import com.shop.ShopCongNghe.dto.user.UserResponse;

public class OrderResponse {
    private Long id;

    private Float into_money;

    private Long status;

    private UserResponse user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getInto_money() {
        return into_money;
    }

    public void setInto_money(Float into_money) {
        this.into_money = into_money;
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
