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
    private String video;

    @Column( nullable = true )
    private String image;

    @Column( nullable = true )
    private float price;

    @Column( nullable = true )
    private String camera;

    @Column( nullable = true )
    private String cameraSelf;

    @Column( nullable = true )
    private String battery;

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

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



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private ColorEntity color;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "image_id")
//    private ImageEntity image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "os_id")
    private OSEntity os;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id")
    private RamEntity ram;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rom_id")
    private RomEntity rom;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

//    public ImageEntity getImage() {
//        return image;
//    }
//
//    public void setImage(ImageEntity image) {
//        this.image = image;
//    }

    public OSEntity getOs() {
        return os;
    }

    public void setOs(OSEntity os) {
        this.os = os;
    }

    public RamEntity getRam() {
        return ram;
    }

    public void setRam(RamEntity ram) {
        this.ram = ram;
    }

    public RomEntity getRom() {
        return rom;
    }

    public void setRom(RomEntity rom) {
        this.rom = rom;
    }
}
