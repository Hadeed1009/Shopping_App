package com.example.laylo.Modelss;

import android.widget.ImageView;

public class HomeModel {
    int image;
    String name,price,size,description;

    public HomeModel(int image, String name) {
        this.image = image;
        this.name = name;
    }
    public HomeModel(int image, String name, String price, String size, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
