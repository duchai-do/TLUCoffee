package com.example.vn.edu.tlu.m2151060214.ui.Caffe;

public class CoffeeItem {

    private String name;
    private String price;
    private int iconResId; // ID của tài nguyên icon

    public CoffeeItem(String name, String price, int iconResId) {
        this.name = name;
        this.price = price;
        this.iconResId = iconResId;
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

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
