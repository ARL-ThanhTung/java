package com.shop.ShopCongNghe.dto.order_detail;

import com.shop.ShopCongNghe.dto.order.OrderResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;

import java.sql.Date;

public class OrderDetailResponse {
    private Long id;

    private Long quantity;

    private Float into_money;

    private Date date_note;

    private OrderResponse order;
    private ProductDetailResponse product_detail;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getInto_money() {
        return into_money;
    }

    public void setInto_money(Float into_money) {
        this.into_money = into_money;
    }

    public Date getDate_note() {
        return date_note;
    }

    public void setDate_note(Date date_note) {
        this.date_note = date_note;
    }

    public OrderResponse getOrder() {
        return order;
    }

    public void setOrder(OrderResponse order) {
        this.order = order;
    }

    public ProductDetailResponse getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(ProductDetailResponse product_detail) {
        this.product_detail = product_detail;
    }
}
