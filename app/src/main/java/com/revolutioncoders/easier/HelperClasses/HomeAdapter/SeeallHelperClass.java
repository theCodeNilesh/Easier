package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

public class SeeallHelperClass {

    int image;
    String title, price, subtxt;

    public SeeallHelperClass(int image, String title, String price, String subtxt) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.subtxt = subtxt;
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

    public String getSubtxt() {
        return subtxt;
    }
}
