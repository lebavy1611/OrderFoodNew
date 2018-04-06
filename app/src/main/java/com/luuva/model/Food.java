package com.luuva.model;

import java.io.Serializable;

/**
 * Created by luuva on 3/24/2018.
 */

public class Food implements Serializable{
    private int id;
    private String nameFood;
    private int price;
    private int image;
    private String address;
    private int shopId;
    private int catId;

    public Food(int id, String nameFood, int price, int image, String address, int shopId, int catId) {
        this.id = id;
        this.nameFood = nameFood;
        this.price = price;
        this.image = image;
        this.address = address;
        this.shopId = shopId;
        this.catId = catId;
    }

    public Food(String nameFood, int price, String address) {
        this.nameFood = nameFood;
        this.price = price;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public Food() {

    }
}
