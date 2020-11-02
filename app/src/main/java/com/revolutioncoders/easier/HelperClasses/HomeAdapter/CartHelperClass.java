package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

public class CartHelperClass {

    int image;
    String title, price, quantity;

    public CartHelperClass(int image, String title, String price, String quantity) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }
}
