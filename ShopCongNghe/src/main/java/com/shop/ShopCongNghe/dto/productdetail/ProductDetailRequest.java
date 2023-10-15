package com.shop.ShopCongNghe.dto.productdetail;

import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;

public class ProductDetailRequest {
    //private ProductDetailEntity productDetailEntity;
    //private Long id;
    private String description;
    private String video;

    private String chip;
    private String screen;

    private String image;
    private float price;
    private String camera;
    private String cameraSelf;
    private String battery;

    private Long quantity_remain;



    private Long product_id;
    private Long ram_id;
    private Long rom_id;
    private Long os_id;
    private Long color_id;
    //private Long image_id;
    private Long card_id;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Long getQuantity_remain() {
        return quantity_remain;
    }

    public void setQuantity_remain(Long quantity_remain) {
        this.quantity_remain = quantity_remain;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    //    public ProductDetailEntity getProductDetailEntity() {
//        return productDetailEntity;
//    }
//
//    public void setProductDetailEntity(ProductDetailEntity productDetailEntity) {
//        this.productDetailEntity = productDetailEntity;
//    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getRam_id() {
        return ram_id;
    }

    public void setRam_id(Long ram_id) {
        this.ram_id = ram_id;
    }

    public Long getRom_id() {
        return rom_id;
    }

    public void setRom_id(Long rom_id) {
        this.rom_id = rom_id;
    }

    public Long getOs_id() {
        return os_id;
    }

    public void setOs_id(Long os_id) {
        this.os_id = os_id;
    }

    public Long getColor_id() {
        return color_id;
    }

    public void setColor_id(Long color_id) {
        this.color_id = color_id;
    }

//    public Long getImage_id() {
//        return image_id;
//    }
//
//    public void setImage_id(Long image_id) {
//        this.image_id = image_id;
//    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }
}
