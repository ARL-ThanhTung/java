package com.shop.ShopCongNghe.dto.productdetail;

import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;

public class ProductDetailRequest {
    private ProductDetailEntity productDetailEntity;
    private Long product_id;
    private Long ram_id;
    private Long rom_id;
    private Long os_id;
    private Long color_id;
    private Long image_id;
    private Long card_id;


    public ProductDetailEntity getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(ProductDetailEntity productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }

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

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }
}
