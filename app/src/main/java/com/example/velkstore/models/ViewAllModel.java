package com.example.velkstore.models;

import java.io.Serializable;

public class ViewAllModel implements Serializable {

    String name;
    String img_url;
    int price;
    String type;

    public ViewAllModel() {
    }

    public ViewAllModel(String name, String img_url, int price, String type) {
        this.name = name;
        this.img_url = img_url;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getDescription() {
        return 0;
    }
}
