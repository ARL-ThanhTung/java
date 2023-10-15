package com.shop.ShopCongNghe.entity.product;


import com.shop.ShopCongNghe.entity.product.detail.*;
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
        name="tbl_product_detail"
)
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY  )
    private Long id;

    @Column( nullable = true )
    private String description;

    @Column( nullable = true )
    private float price;

    @Column( nullable = true )
    private String camera;

    @Column( nullable = true )
    private String cameraSelf;

    @Column( nullable = true )
    private String battery;



    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCameraSelf() {
        return cameraSelf;
    }

    public void setCameraSelf(String cameraSelf) {
        this.cameraSelf = cameraSelf;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }


    public ProductEntity getProduct() {
        return product;
    }

    public List<CardEntity> getCards() {
        return cards;
    }

    public List<ColorEntity> getColors() {
        return colors;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public List<OSEntity> getOss() {
        return oss;
    }

    public List<RamEntity> getRams() {
        return rams;
    }

    public List<RomEntity> getRoms() {
        return roms;
    }

    public void checkProduct(ProductEntity product){
        this.product = product;
    }
    public void checkRam(List<RamEntity> ramEntity){
        this.rams = ramEntity;
    }
    public void checkRom(List<RomEntity> romEntity){
        this.roms = romEntity;
    }
    public void checkOS(List<OSEntity> osEntity){
        this.oss = osEntity;
    }
    public void checkColor(List<ColorEntity> colors){
        this.colors = colors;
    }
    public void checkImage(List<ImageEntity> images){
        this.images = images;
    }
    public void checkCard(List<CardEntity> cards){
        this.cards = cards;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardEntity> cards = new ArrayList<>();

    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ColorEntity> colors = new ArrayList<>();

    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImageEntity> images = new ArrayList<>();

    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OSEntity> oss = new ArrayList<>();

    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RamEntity> rams = new ArrayList<>();

    @OneToMany(mappedBy = "product_detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RomEntity> roms = new ArrayList<>();


}
