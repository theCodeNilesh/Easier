package com.revolutioncoders.easier.model;

import android.graphics.Bitmap;

public class CategoryItem {

    Integer itemId;
    String price, title, subtxt, imageUrl;

    public CategoryItem(Integer itemId, String imageUrl, String price, String title, String subtxt) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
        this.price = price;
        this.title = title;
        this.subtxt = subtxt;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtxt() {
        return subtxt;
    }

    public void setSubtxt(String subtxt) {
        this.subtxt = subtxt;
    }
}
