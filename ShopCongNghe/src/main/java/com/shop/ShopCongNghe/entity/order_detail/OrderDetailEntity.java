package com.shop.ShopCongNghe.entity.order_detail;


import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_order_detail"
)
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY  )
    private Long id;

    @Column( nullable = true )
    private Long quantity;

    @Column( nullable = true )
    private Float into_money;

    @Column( nullable = true )
    private Date date_note;

    @Column( nullable = true )
    @Lob
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producr_detail_id")
    private ProductDetailEntity product_detail;

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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductDetailEntity getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(ProductDetailEntity product_detail) {
        this.product_detail = product_detail;
    }
}
