package com.shop.ShopCongNghe.dto.order_detail;


import java.sql.Date;

public class OrderDetailRequest {

    private Long id;

    private Long quantity;

    private Float into_money;

    private Date date_note;

    private String color;

    private Long order_id;
    private Long product_detail_id;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(Long product_detail_id) {
        this.product_detail_id = product_detail_id;
    }
}
