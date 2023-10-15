package com.shop.ShopCongNghe.entity.product.detail;

import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import lombok.*;

import javax.persistence.*;

import com.shop.ShopCongNghe.entity.product.ProductEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(
        name="tbl_color"
)
public class ColorEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY  )
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


    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductDetailEntity> productDetail = new ArrayList<>();

}
