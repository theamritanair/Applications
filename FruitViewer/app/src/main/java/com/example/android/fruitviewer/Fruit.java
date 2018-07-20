package com.example.android.fruitviewer;

public class Fruit {

    private String fruitName;
    private int imageID;

    public Fruit(String tfruitName, int image_ID){
        fruitName= tfruitName;
        imageID = image_ID;
    }

    public String getFruitName(){
        return fruitName;
    }

    public int getImage(){
        return imageID;
    }



}
