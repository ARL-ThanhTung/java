package com.shop.ShopCongNghe.entity.category;


import com.shop.ShopCongNghe.entity.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(
        name="tbl_category"
)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY  )
    private Long id;

    @Column( nullable = true )
    private String name;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<>();

}
