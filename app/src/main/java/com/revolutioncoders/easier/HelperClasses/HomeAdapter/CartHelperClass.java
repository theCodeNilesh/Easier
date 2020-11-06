package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

import android.widget.ImageView;

public class CartHelperClass {

    String title, price, quantity,image;
    int id,pid;

    public int getPid() {
        return pid;
    }

    public CartHelperClass(String  image, String title, String price, String quantity, int id, int pid) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
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
