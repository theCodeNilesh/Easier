package com.revolutioncoders.easier.model;

public class CategoryItem {

    Integer itemId;
    Integer imageUrl;
    String price, title, subtxt;

    public CategoryItem(Integer itemId, Integer imageUrl, String price, String title, String subtxt) {
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

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
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
