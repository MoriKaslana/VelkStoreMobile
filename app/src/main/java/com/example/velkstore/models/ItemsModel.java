package com.example.velkstore.models;

public class ItemsModel {
    private String name;
    private String rating;
    private String description;
    private String img_url;
    private String type;

    public ItemsModel() {
    }

    public ItemsModel(String name, String rating, String description, String img_url, String type) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.img_url = img_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getType() {
        return type;
    }
}
