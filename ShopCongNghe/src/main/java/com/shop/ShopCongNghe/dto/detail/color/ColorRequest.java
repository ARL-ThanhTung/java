package com.shop.ShopCongNghe.dto.detail.color;

import com.shop.ShopCongNghe.dto.detail.image.ImageResponse;

import java.util.List;

public class ColorRequest {
    private Long id;
    private String name;

    private String image_link;

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
