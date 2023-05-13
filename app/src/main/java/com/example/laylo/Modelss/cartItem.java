package com.example.laylo.Modelss;

public class cartItem {
    public String name, price, size, quantity, image;

    public cartItem(String image,String name, String price, String size, String quantity) {
        this.image=image;
        this.name = name;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
    }
}
