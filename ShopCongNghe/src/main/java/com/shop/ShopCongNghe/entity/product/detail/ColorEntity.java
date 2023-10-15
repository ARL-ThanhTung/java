package com.shop.ShopCongNghe.entity.product.detail;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private ProductEntity product_detail;


}
