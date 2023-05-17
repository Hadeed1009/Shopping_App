package com.example.laylo.Modelss;

public class CartModel {
    int img, img_incr, img_decr;
    String name, size, price, quantity;

    public CartModel(int img, int img_incr, int img_decr, String name, String size, String price, String quantity) {
        this.img = img;
        this.img_incr = img_incr;
        this.img_decr = img_decr;
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public CartModel(int img, String name, String size, String price, String quantity) {
        this.img = img;
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public int getImg_incr() {
        return img_incr;
    }

    public void setImg_incr(int img_incr) {
        this.img_incr = img_incr;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public int getImg_decr() {
        return img_decr;
    }
    public void setImg_decr(int img_decr) {
        this.img_decr = img_decr;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
