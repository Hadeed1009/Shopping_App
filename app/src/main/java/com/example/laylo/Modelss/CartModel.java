package com.example.laylo.Modelss;

public class CartModel {
    int img,img2,img3;
    String text, text2, text3, text4;

    public CartModel(int img, int img2, int img3, String text, String text2, String text3, String text4) {
        this.img = img;
        this.img2 = img2;
        this.img3 = img3;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getImg2() {
        return img2;
    }
    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }
    public void setImg3(int img3) {
        this.img3 = img3;
    }

    public String getText2() {
        return text2;
    }
    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }
    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }
}
