package com.shop.ShopCongNghe.entity.product;

import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.entity.product.detail.CardEntity;
import com.shop.ShopCongNghe.entity.product.detail.RamEntity;
import com.shop.ShopCongNghe.entity.product.detail.RomEntity;
import lombok.*;

import javax.persistence.*;

import com.shop.ShopCongNghe.entity.product.detail.ColorEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(
        name="tbl_product"
)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY  )
    private Long id;

    @Column( nullable = true )
    private String title;

    @Column( nullable = true )
    private String name;

    @Column( nullable = true )
    private String image;

    @Column( nullable = true )
    private String description;


    public Long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDetailEntity> getProductDetails() {
        return productDetail;
    }

    public void setProductDetails(List<ProductDetailEntity> productDetails) {
        this.productDetail = productDetails;
    }


    public BranchEntity getBranch() {
        return branch;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void checkBranch(BranchEntity branch){
        this.branch = branch;
    }
    public void checkCategory( CategoryEntity category ){
        this.category = category;
    }



    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductDetailEntity> productDetail = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;



}
