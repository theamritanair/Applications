package com.example.android.shopkart;

public class Phone {
    String manufacturer;
    String model;
    String price;
    String imageUrl;

    public Phone( String model,String imageUrl) {
//        this.manufacturer = manufacturer;
        this.model = model;
//        this.price = price;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
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
        this.imageUrl = imageUrl;
    }
}