package com.shop.ShopCongNghe.dto.productdetail;

import com.shop.ShopCongNghe.dto.detail.ram.RamResponse;
import com.shop.ShopCongNghe.dto.detail.rom.RomResponse;
import com.shop.ShopCongNghe.dto.detail.image.ImageResponse;
import com.shop.ShopCongNghe.dto.detail.os.OsResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.card.CardResponse;
import com.shop.ShopCongNghe.dto.product.ProductResponse;

import java.awt.*;
import java.util.List;

public class ProductDetailResponse {

    private Long id;
    private String description;
    private Long quantity_remain;
    private String video;

    private String image;
    private float price;
    private String camera;
    private String cameraSelf;
    private String battery;

    private String chip;
    private String screen;


    private RamResponse ram;
    private RomResponse rom;
    //private ImageResponse image;
    private OsResponse os;

    private CardResponse card;

    private ProductResponse product ;


    private List<ColorResponse> color;

    public List<ColorResponse> getColor() {
        return color;
    }

    public void setColor(List<ColorResponse> color) {
        this.color = color;
    }

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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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



    public RamResponse getRam() {
        return ram;
    }

    public void setRam(RamResponse ram) {
        this.ram = ram;
    }

    public RomResponse getRom() {
        return rom;
    }

    public void setRom(RomResponse rom) {
        this.rom = rom;
    }

//    public ImageResponse getImage() {
//        return image;
//    }
//
//    public void setImage(ImageResponse image) {
//        this.image = image;
//    }

    public OsResponse getOs() {
        return os;
    }

    public void setOs(OsResponse os) {
        this.os = os;
    }



    public CardResponse getCard() {
        return card;
    }

    public void setCard(CardResponse card) {
        this.card = card;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }
}
