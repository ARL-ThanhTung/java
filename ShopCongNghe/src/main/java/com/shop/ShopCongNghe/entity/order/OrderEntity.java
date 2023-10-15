package com.shop.ShopCongNghe.entity.order;


import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;
import com.shop.ShopCongNghe.entity.role.RoleEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_order"
)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY  )
    private Long id;

    @Column( nullable = true )
    private Float total_amount;

    @Column( nullable = true )
    private Long status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetailEntity> order_detail = new ArrayList<>();


    public List<OrderDetailEntity> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetailEntity> order_detail) {
        this.order_detail = order_detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
