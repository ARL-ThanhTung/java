package com.shop.ShopCongNghe.dto.order;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailRequest;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;

import java.util.List;

public class OrderRequest {

    private Long id;

    private Long user_id;

    private Float total_amount;

    private Long status;

    private List<OrderDetailRequest> OrderDetail;


    public List<OrderDetailRequest> getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(List<OrderDetailRequest> orderDetail) {
        OrderDetail = orderDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Float total_amount) {
        this.total_amount = total_amount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
