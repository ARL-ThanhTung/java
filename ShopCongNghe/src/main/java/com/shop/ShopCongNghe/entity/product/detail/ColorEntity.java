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

    @Column( nullable = true )
    @Lob
    private String image_link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity product_details;

//    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ImageEntity> image = new ArrayList<>();


    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ProductDetailEntity getProduct_detail() {
        return product_details;
    }

    public void setProduct_detail(ProductDetailEntity product_detail) {
        this.product_details = product_detail;
    }


}
