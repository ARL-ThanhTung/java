package com.shop.ShopCongNghe.dto.productdetail;

import com.shop.ShopCongNghe.dto.detail.ram.RamResponse;
import com.shop.ShopCongNghe.dto.detail.rom.RomResponse;
import com.shop.ShopCongNghe.dto.detail.image.ImageResponse;
import com.shop.ShopCongNghe.dto.detail.os.OsResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.card.CardResponse;
import com.shop.ShopCongNghe.dto.product.ProductResponse;

import java.util.List;

public class ProductDetailResponse {

    private Long id;
    private String description;
    private float price;
    private String camera;
    private String cameraSelf;
    private String battery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private List<RamResponse> ram;
    private List<RomResponse> rom;
    private List<ImageResponse> image;
    private List<OsResponse> os;
    private List<ColorResponse> color;
    private List<CardResponse> card;

    private ProductResponse product ;


    public List<RamResponse> getRam() {
        return ram;
    }

    public void setRam(List<RamResponse> ram) {
        this.ram = ram;
    }

    public List<RomResponse> getRom() {
        return rom;
    }

    public void setRom(List<RomResponse> rom) {
        this.rom = rom;
    }

    public List<ImageResponse> getImage() {
        return image;
    }

    public void setImage(List<ImageResponse> image) {
        this.image = image;
    }

    public List<OsResponse> getOs() {
        return os;
    }

    public void setOs(List<OsResponse> os) {
        this.os = os;
    }

    public List<ColorResponse> getColor() {
        return color;
    }

    public void setColor(List<ColorResponse> color) {
        this.color = color;
    }

    public List<CardResponse> getCard() {
        return card;
    }

    public void setCard(List<CardResponse> card) {
        this.card = card;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }
}
