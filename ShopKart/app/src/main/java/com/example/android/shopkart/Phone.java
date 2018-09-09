package com.example.android.shopkart;

import com.google.gson.annotations.SerializedName;

public class Phone {
    String manufacturer;
    String model;
    String price;
    String image;

    public Phone(String manufacturer,String price, String model,String imageUrl) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.image = imageUrl;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.image = imageUrl;
    }
}