package com.shop.ShopCongNghe.dto.order_detail;

import com.shop.ShopCongNghe.dto.order.OrderResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;

import java.sql.Date;
import java.text.SimpleDateFormat;
public class OrderDetailResponse {
    private Long id;

    private Long quantity;

    private Float into_money;

    private Date date_note;

    private String color;
    public String getDateNoteAsString() {
        if (date_note != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date_note);
        }
        return null;
    }

    private OrderResponse order;
    private ProductDetailResponse product_detail;


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

//    public Date getDate_note() {
//        return date_note;
//    }

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
