package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

public class FirstHelperClass {

    int image;
    String title, subtxt, price;

    public FirstHelperClass(int image, String title, String subtxt, String price) {
        this.image = image;
        this.title = title;
        this.subtxt = subtxt;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtxt() {
        return subtxt;
    }

    public String getPrice() {
        return price;
    }
}
